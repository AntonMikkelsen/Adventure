import java.util.Scanner;
import static java.nio.file.Files.move;
import static java.nio.file.Files.readString;

public class UserInterface {
    private Adventure adventure;
    Adventure adv = new Adventure();

    public void UserInterface() {
        this.adv = adventure;


            System.out.println("Commands:");
            System.out.println("- go north/east/south/west: Move in a direction.");
            System.out.println("- look: Show description of the current room.");
            System.out.println("- help: Show this help message.");
            System.out.println("- exit: Exit the game.");


        public void play () {
            Scanner scanner = new Scanner(System.in);
            String command = "";

            System.out.println("Welcome to the adventure game!");
            System.out.println("You are in " + adv.getCurrentRoomName());
            System.out.println(adv.getCurrentRoomDescription());

            System.out.println("What would you like to do?");

            command = scanner.nextLine().toLowerCase();


            while (!command.equalsIgnoreCase("exit")) {

                System.out.print("> ");
                command = scanner.nextLine();

                switch (command) {
                    case "north":
                        adv.getPlayer().goNorth();

                        break;
                    case "east":
                        adv.getPlayer().goEast();
                        break;
                    case "south":
                        adv.getPlayer().goSouth();
                        break;
                    case "west":
                        adv.getPlayer().goWest();
                        break;

                    case "help":

                    case "look":
                    default:
                        System.out.println("Invalid direction! Type 'help' for a list of commands.");
                        return;
                }



//                if (command.equals("exit")) {
//                    System.out.println("Thanks for playing!"); //Hvis spilleren skriver "exit" lukker spillet og en besked fortæller dette.
//                    break;
//                } else if (command.equals("look")) { //hvis spilleren skriver "look", får spilleren en besked om hvor de er i spillet/hvilket rum.
//                    System.out.println("You are in " + adv.getCurrentRoomName());
//                    System.out.println(adv.getCurrentRoomDescription());
//                } else if (command.equals("help")) { //hvis spilleren skriver "help", får de en liste af mulige kommandoer.
//                    UserInterface.printHelp();
//                } else if (command.startsWith("go ")) {
//                    move(command.substring(3));
//                } else {
//                    System.out.println("Unknown command! Type 'help' for a list of commands.");
//                }
//            }
//            scanner.close();
        }

        private void move (String substring){
            System.out.println("you moved to " + adv.getCurrentRoomName());
            System.out.println(adv.getCurrentRoomDescription());
        }
    }
}
