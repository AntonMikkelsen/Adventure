import java.util.ArrayList;
import java.util.HashMap;

public class Room {


    private String name;
    private String description;
    private Room east, south, west, north;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items = null;
    private ArrayList<Enemy> enemies;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName() != null && item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addEnemy (Enemy enemy){
        enemies.add(enemy);
    }

    public void removeEnemy (Enemy enemy){
        enemies.remove(enemy);
    }

    public Enemy getEnemy (){
        if (enemies.isEmpty()){
            return null;
        }
        return enemies.getFirst();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

}
