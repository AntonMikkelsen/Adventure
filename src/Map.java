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
        ArrayList<Enemy> EnemiesRoom1 = new ArrayList<>();
        ArrayList<Item> itemsRoom2 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom2 = new ArrayList<>();
        ArrayList<Item> itemsRoom3 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom3 = new ArrayList<>();
        ArrayList<Item> itemsRoom4 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom4 = new ArrayList<>();
        ArrayList<Item> itemsRoom5 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom5 = new ArrayList<>();
        ArrayList<Item> itemsRoom6 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom6 = new ArrayList<>();
        ArrayList<Item> itemsRoom7 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom7 = new ArrayList<>();
        ArrayList<Item> itemsRoom8 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom8 = new ArrayList<>();
        ArrayList<Item> itemsRoom9 = new ArrayList<>();
        ArrayList<Enemy> EnemiesRoom9 = new ArrayList<>();




        Room room1 = new Room("Room 1", "Large room, littered with pillars, torches and a few chests");

        Weapon gorlokClub = new MeleeWeapon("Club", "Tree club", 10);
        room1.addEnemy(new Enemy("Gorlok", "Giant, not very smart and very slow", gorlokClub, 10));

        room1.addItem(new Item("compass", "shows you the way you are headed"));


        room1.addItem(new Food("apple", "a red fruit", 5));


        room1.addItem(new RangedWeapon("Staff", "Staff of wither, with limited uses, withers the enemy, dealing high damage", 5, 10));



        Room room2 = new Room("Room 2", "Smaller room, resembling a cathedral, with a religious theme");



        room2.addItem(new MeleeWeapon("sword", "Large sword, shiny and engraved with an unknown language", 10));

        room2.addItem(new Food("apple", "a red fruit", 10));




        Room room3 = new Room("Room 3", "Open area, forest-like, with trees and a bridge to pass the river throwing through the land");




        room3.addItem(new Item("apple", "red apple, nutritional, restores hp"));









        Room room4 = new Room("Room 4", "Passing over the bridge, you get deeper into the forest, it gets darker and the trees larger");


        room4.addItem(new Food("apple", "a red fruit", 10));




        Room room5 = new Room("Room 5", "Large room, with enormous statues resembling knights and religious figures - it seems like they are watching you");




        room5.addItem(new Food("apple", "a red fruit", 10));




        Room room6 = new Room("Room 6", "A field with cows and other animals, in the middle is a grassy knoll");




        room6.addItem(new Food("apple", "a red fruit", 10));




        Room room7 = new Room("Room 7", "Storage room of some sort, boxes of wood are stacked on the floor and a cellar with a lock on it, can be seen in the back");


        room7.addItem(new Item("rusted key", "brownish rusted key, may be useful further ahead"));
        room7.addItem(new Food("apple", "a red fruit", 10));




        Room room8 = new Room("Room 8", "A coliseum, littered with weapons and blood, you hear a growling from a steel door, a challenger might be appearing..");
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
