
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    Adventure adv = new Adventure();


    public void play() {
        Scanner scanner = new Scanner(System.in);
        String command;


        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the adventure game!");
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

//                    Enemy enemy = adv.player.getCurrentRoom().getEnemy();
//                    WeaponStatus playerAttack = adv.player.attack();
//                    if(enemy != null){
//                        System.out.println("there's and enemy in the room");
//                        System.out.println(enemy.getName() + " appears");




//                    if (enemy == null) {
//                        System.out.println("there are no enemies to attack here");
//                        break;
//                    }
//                    WeaponStatus attackStatus = adv.getPlayer().attack();
//                    if (attackStatus == WeaponStatus.USED) {
//                        System.out.println("you attacked " + enemy.getName() + " with " + adv.player.getCurrentEquippedItem());
//                        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " left ");
//                        if (enemy.getHealth() <= 0) {
//                            System.out.println(enemy.getName() + " has perished and dropped " + enemy.getWeapon());
//                            Weapon enemyWeapon = enemy.getWeapon();
//                            adv.player.getCurrentRoom().removeEnemy(enemy);
//                            adv.player.getCurrentRoom().addItem(enemyWeapon);
//                        }
//                    } else if (attackStatus == WeaponStatus.NO_AMMO_LEFT) {
//                        System.out.println("Your " + adv.player.getCurrentEquippedItem() + " has no ammo.");
//                    } else if (attackStatus == WeaponStatus.NOTHING_EQUIPPED) {
//                        System.out.println("You dont have anything equipped");
//                    }
//                    break;

                case "exit":
                    if ((!adv.playerDead()) || command.equals("exit")) {
                    System.out.println("thanks for playing!");
                    scanner.close();
                    System.exit(0);
                    break;
                }

//                default:
//                    System.out.println("Invalid direction! Type 'help' for a list of commands.");
//                    break;
            }
        }
    }
}
