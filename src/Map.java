import java.util.ArrayList;


public class Map {
    private Room firstRoom;
    private Room currentRoom;


    public Room getCurrentRoom() {
        return currentRoom;
    }


    public Map(){
        this.createRooms();
    }


    public void createRooms(){


        ArrayList<Item> itemsRoom1 = new ArrayList<>();
        ArrayList<Item> itemsRoom2 = new ArrayList<>();
        ArrayList<Item> itemsRoom3 = new ArrayList<>();
        ArrayList<Item> itemsRoom4 = new ArrayList<>();
        ArrayList<Item> itemsRoom5 = new ArrayList<>();
        ArrayList<Item> itemsRoom6 = new ArrayList<>();
        ArrayList<Item> itemsRoom7 = new ArrayList<>();
        ArrayList<Item> itemsRoom8 = new ArrayList<>();
        ArrayList<Item> itemsRoom9 = new ArrayList<>();


        Room room1 = new Room("Room 1", "Large room, littered with pillars, torches and a few chests");


        room1.addItem(new Item("compass", "shows you the way you are headed"));

        room1.addItem(new Food("Apple", "a red fruit", 10));

        Room room2 = new Room("Room 2", "Smaller room, resembling a cathedral, with a religious theme");


        room2.addItem(new Item("Long sword", "Large sword, shiny and engraved with an unknown language"));




        Room room3 = new Room("Room 3", "Open area, forest-like, with trees and a bridge to pass the river throwing through the land");


        room3.addItem(new Item("apple", "red apple, nutritional, restores hp"));




        Room room4 = new Room("Room 4", "Passing over the bridge, you get deeper into the forest, it gets darker and the trees larger");




        Room room5 = new Room("Room 5", "");
        Room room6 = new Room("Room 6", "");
        Room room7 = new Room("Room 7", "");
        Room room8 = new Room("Room 8", "");
        Room room9 = new Room("Room 9", "");




        firstRoom = room1;
        currentRoom = firstRoom;






        connectWestEast(room1, room2);
        connectWestEast(room2, room3);
        connectNorthSouth(room3, room6);
        connectNorthSouth(room6, room9);
        connectNorthSouth(room1, room4);
        connectNorthSouth(room4, room7);
        connectWestEast(room7, room8);
        connectWestEast(room8, room9);
        connectNorthSouth(room5, room8);
    }
    private void connectWestEast(Room west, Room east){
        west.setEast(east);
        east.setWest(west);
    }
    private void connectNorthSouth(Room north, Room south) {
        north.setSouth(south);
        south.setNorth(north);
    }


}
