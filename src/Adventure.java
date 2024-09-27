import java.util.Locale;
import java.util.Scanner;

    public class Adventure{
        private Room currentRoom;

        public Adventure(){
            createRooms();
        }

        public void createRooms(){

            Room room1 = new Room("Room 1", "Large room, littered with pillars, torches and a few chests");
            Room room2 = new Room("Room 2", "Smaller room, resembling a cathedral, with a religious theme");
            Room room3 = new Room("Room 3", "Open area, forest-like, with trees and a bridge to pass the river throwing through the land");
            Room room4 = new Room("Room 4", "Passing over the bridge, you get deeper into the forest, it gets darker and the trees larger");
            Room room5 = new Room("Room 5", "");
            Room room6 = new Room("Room 6", "");
            Room room7 = new Room("Room 7", "");
            Room room8 = new Room("Room 8", "");
            Room room9 = new Room("Room 9", "");

            currentRoom = room1;

            room1.setEast(room2);
            room1.setSouth(room4);

            room2.setEast(room3);
            room2.setWest(room1);

            room3.setSouth(room6);
            room3.setWest(room2);

            room4.setNorth(room1);
            room4.setSouth(room7);

            room5.setSouth(room8);

            room6.setSouth(room9);
            room6.setNorth(room3);

            room7.setNorth(room4);
            room7.setEast(room8);

            room8.setEast(room9);
            room8.setNorth(room5);

            room9.setWest(room8);
            room9.setNorth(room6);

            System.out.println("\nSpawn location: Room 1");
            System.out.println("What would you like to do?");
            System.out.println("---Type help to view the possible commands---");




        }

        public void play () {
            Scanner userInput = new Scanner(System.in);

            Scanner scanner = new Scanner(System.in);
            String command;

            System.out.println("Welcome to the adventure game!");
            printHelp();
            System.out.println("You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());

            while (true) {
                System.out.print("> ");
                command = scanner.nextLine().toLowerCase();

                if (command.equals("exit")) {
                    System.out.println("Thanks for playing!");
                    break;
                } else if (command.equals("look")) {
                    System.out.println("You are in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                } else if (command.equals("help")) {
                    printHelp();
                } else if (command.startsWith("go ")) {
                    move(command.substring(3));
                } else {
                    System.out.println("Unknown command! Type 'help' for a list of commands.");
                }
            }
            scanner.close();
        }

        private void move(String direction) {
            Room nextRoom = null;

            switch (direction) {
                case "north":
                    nextRoom = currentRoom.getNorth();
                    break;
                case "east":
                    nextRoom = currentRoom.getEast();
                    break;
                case "south":
                    nextRoom = currentRoom.getSouth();
                    break;
                case "west":
                    nextRoom = currentRoom.getWest();
                    break;
                default:
                    System.out.println("Invalid direction! Type 'help' for a list of commands.");
                    return;
            }

            if (nextRoom != null) {
                currentRoom = nextRoom;
                System.out.println("You are in " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
            } else {
                System.out.println("You cannot go that way.");
            }
        }
            private void printHelp () {
                System.out.println("Commands:");
                System.out.println("- go north/east/south/west: Move in a direction.");
                System.out.println("- look: Show description of the current room.");
                System.out.println("- help: Show this help message.");
                System.out.println("- exit: Exit the game.");

            }
        }
