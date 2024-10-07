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
                    break;

                case "look", "l":
                    System.out.println("You look around and realize you are in " + adv.getCurrentRoomName() + "\nThe room can be described with the following: " + adv.getCurrentRoomDescription());
                    ArrayList<Item> inventory = adv.getPlayer().getCurrentRoom().getItems();
                    if (inventory.isEmpty()) {
                        System.out.println("This room has nothing of importance in it..");
                    } else {
                        System.out.println("There are following items in the room: ");
                        int counter = 0;
                        for (Item item : inventory) {
                            counter++;
                            System.out.println(counter + "." + "a" + " "+ item);
                        }
                    }
                    break;

                case "eat":
                    if (temp.length > 2){
                        
                    }

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
                    } else {
                        System.out.println("There is nothing in your inventory currently");
                    }
                    break;

                case "take":
                    if (temp.length > 2) {
                        System.out.println("command not possible, instead try take + item name");
                    } else {
                        System.out.println(adv.player.takeItem(temp[1]));}
                    break;

                case "drop":
                    if (temp.length > 2) {
                        System.out.println("command not possible, instead try take + item name");
                    } else {
                        System.out.println(adv.player.dropItem(temp[1]));}
                    break;

                case "exit":
                    System.out.println("thanks for playing!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid direction! Type 'help' for a list of commands.");
                    break;
            }
        }
    }
}

