public class Player {
        private Room currentRoom;

        public Player(Room currentRoom){

            this.currentRoom = currentRoom;

        }
            public void goNorth () {

                if (currentRoom.getNorth() != null) {
                    currentRoom = currentRoom.getNorth();
                } else {
                    System.out.println("No doors this way, try again");
                }
            }

            public void goSouth () {
                if (currentRoom.getSouth() != null) {
                    currentRoom = currentRoom.getNorth();
                } else {
                    System.out.println("No doors this way, try again");
                }
            }

            public void goEast () {

                if (currentRoom.getEast() != null) {
                    currentRoom = currentRoom.getEast();
                } else {
                    System.out.println("No doors this way, try again");
                }
            }

            public void goWest () {

                if (currentRoom.getWest() != null) {
                    currentRoom = currentRoom.getWest();
                } else {
                    System.out.println("No doors this way, try again");
                }
            }

        public Room getCurrentRoom(){
            return currentRoom;
        }

        public Room move (String direction){
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
                    return null;
            }

            if (nextRoom != null) {
                currentRoom = nextRoom;
                System.out.println("You are in " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
            } else {
                System.out.println("You cannot go that way.");
            }
            return null;
        }
}