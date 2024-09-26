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

        }

        public void play (){
            Scanner userInput = new Scanner(System.in);
            String userChoice = userInput.nextLine();


            while ()

            switch (userChoice){
                case "go north", "go n":
                    if (!(currentRoom.getEast()==null)){

                    }

            }


            while(true){

            }
        }
}
