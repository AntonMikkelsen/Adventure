
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    Adventure adv = new Adventure();


    public void play() {
        Scanner scanner = new Scanner(System.in);
        String command;


        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Master of Dungeons!");
        System.out.println("You are in " + adv.getCurrentRoomName());
        System.out.println(adv.getCurrentRoomDescription());






        System.out.println("You have the following command options:");
        System.out.println("- go north/east/south/west: Move in a direction.");
        System.out.println("- look: Show description of the current room.");
        System.out.println("- help: Show this help message.");
        System.out.println("- exit: Exit the game.");
        System.out.println("- look: Look around the room too see items, room name and description.");
        System.out.println("- take <item name>: takes a specific item, and puts it in your inventory.");
        System.out.println("- drop <item name>: drops a specific item, and leaves it in the room");
        System.out.println("- inventory: looks at your inventory and lists items in it");






        System.out.println("What would you like to do?");
        System.out.println("------------------------------------------------------------------------------------------------------");




        while (true) {

            System.out.print("> ");
            command = scanner.nextLine().trim();


            String[] temp = command.split(" ");


            switch (temp[0].toLowerCase()) {
                case "north", "n":
                case "east", "e":
                case "south", "s":
                case "west", "w":
                    adv.move(temp[0]);
                    break;


                case "help", "h":
                    System.out.println("- go north/east/south/west: Move in a direction.");
                    System.out.println("- look: Show description of the current room.");
                    System.out.println("- help: Show this help message.");
                    System.out.println("- exit: Exit the game.");
                    System.out.println("- take: To take an the desired item by name.");
                    System.out.println("- drop: To drop a specific item by name.");
                    System.out.println("- inventory: looks at your inventory and lists items in it.");
                    System.out.println("- eat: To eat a specific item by name.");
                    System.out.println("- health: To see current player health.");
                    System.out.println("- attack <enemy name>: attacks enemy, if a weapon is equipped and there are enemies present, in current room");
                    System.out.println("- equip <weapon name>: equips desired weapon, which can then be used to attack");
                    break;


                case "look", "l":
                    System.out.println("You look around and realize you are in " + adv.getCurrentRoomName() + "\nThe room can be described with the following: " + adv.getCurrentRoomDescription());
                    ArrayList<Item> inventory = adv.getPlayer().getCurrentRoom().getItems();
                    if (inventory.isEmpty()) {
                        System.out.println("This room has nothing of importance in it.." + "\n");
                    } else {
                        System.out.println("There are following items in the room: " + "\n");
                        int counter = 0;
                        for (Item item : inventory) {
                            counter++;
                            System.out.println(counter + "." + " a" + " " + item);
                        }
                    }
                    if (adv.seeEnemies() != null) {
                        System.out.println("There a following enemies in the room" + " " + adv.seeEnemies());
                    }
                    break;


                case "eat", "consume":
                    if (temp.length > 2) {
                        System.out.println("what would you like to consume?");
                    } else {
                        String foodName = temp[1].trim();
                        String result = adv.eat(foodName);
                        System.out.println(result);
                    }
                    break;


                case "health":
                    System.out.println(adv.getPlayer().toString());
                    break;


                case "inventory":
                    if (!adv.getPlayer().inventory.isEmpty()) {
                        System.out.println("Your inventory currently contains: ");
                        int counter = 0;
                        for (Item item : adv.getPlayer().inventory) {
                            counter++;
                            System.out.println(" " + counter + " " + item);
                        }
                        System.out.println(adv.seeCurrentEquipped());
                        if (adventure.seeCurrentEquipped() == null) {
                            System.out.println("you dont have a weapon equipped");
                        }
                        if (adv.seeCurrentEquipped() != null) {
                            System.out.println("you currently have " + adv.seeCurrentEquipped());
                        }
                    } else {
                        System.out.println("There is nothing in your inventory currently");
                        System.out.println("you currently have " + adv.seeCurrentEquipped());
                    }
                    break;


                case "take":
                    if (temp.length < 2) {
                        System.out.println("command not possible, instead try take + item name");
                    } else {
                        String itemName = temp[1].trim();
                        String result = adv.player.takeItem(itemName);
                        System.out.println(result);

                    }
                    break;


                case "drop":
                    if (temp.length > 2) {
                        System.out.println("command not possible, instead try take + item name");
                    } else {
                        System.out.println(adv.player.dropItem(temp[1]));
                    }
                    break;

                case "equip":
                    if (temp.length > 2) {
                        System.out.println("command not possible, instead try equip + item name");
                    } else {
                        String weaponName = temp[1].trim();
                        WeaponStatus status = adv.getPlayer().equip(weaponName);
                        if (status == WeaponStatus.WEAPON) {
                            System.out.println("You equipped " + weaponName + "!");
                        } else if (status == WeaponStatus.NOT_IN_INVENTORY) {
                            System.out.println("You don't have " + weaponName + " in your inventory.");
                        } else if (status == WeaponStatus.NOT_WEAPON) {
                            System.out.println(weaponName + " is not a weapon.");
                        }
                    }
                    break;


                case "attack":
                    if (command.startsWith("attack")) {
                        String attackName = command.substring(7).trim();
                        if (!attackName.isEmpty()) {
                            Enemy target = null;
                            for (Enemy enemy : adv.player.getCurrentRoom().getEnemies()) {
                                if (enemy.getName().equalsIgnoreCase(attackName)) {
                                    target = enemy;
                                    break;
                                }
                            }
                            if (target != null) {
                                String attackResult = adv.attack(target);
                                System.out.println(attackResult);
                            } else {
                                System.out.println("There is no enemy like that in this room");
                            }
                        }
                    }

                case "exit":
                    if (command.equals("exit")) {
                        System.out.println("thanks for playing!");
                        scanner.close();
                        System.exit(0);
                        break;
                    } else if(adv.getPlayerHealth() <= 0){
                        System.out.println("you died! try again?");
                        scanner.close();
                        System.exit(0);
                        break;
                    }

            }
        }
    }
}
