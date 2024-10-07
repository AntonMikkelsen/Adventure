import java.util.ArrayList;


public class Player {
    private Room currentRoom;
    ArrayList<Item> inventory = new ArrayList<>();
    private double health = 50;


    public Player(Room firstRoom, double health){
        this.health = health;
        currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
    }


    public Room getCurrentRoom(){
        return currentRoom;
    }

    public double getHealth(){
        return health;
    }

    public double consume (Food food){
        health += food.getHealth();

        if (health > 100){
            health = 100;
        }

        return health;
    }

    public Room move (String direction){
        Room nextRoom = null;


        switch (direction.toLowerCase()) {
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
            return currentRoom;
        } else {
            System.out.println("You cannot go that way.");
        }
        return null;
    }


    public String takeItem(String itemName){
        Item foundItem = currentRoom.findItem(itemName);

        if (foundItem != null) {
            inventory.add(foundItem);
            currentRoom.removeItem(foundItem);
            return "You take " + itemName + " from " + currentRoom.getName();
        } else return "There is no such item in " + currentRoom.getName();
    }
    public String dropItem(String itemName){
        Item foundItem = findIteminventory(itemName);

        if (foundItem != null) {
            inventory.remove(foundItem);
            currentRoom.addItem(foundItem);
            return "You dropped " + itemName + " in " + currentRoom.getName();
        } else return "There is no " + itemName + " in your inventory";
    }
    public Item findIteminventory(String itemName){
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "health is equal to: " + health;
    }
}
