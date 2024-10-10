import java.util.ArrayList;




public class Player {
    private Room currentRoom;
    ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Item> equipped = new ArrayList<>();
    private double health;
    private final double maxHealth;
    private Weapon currentEquipped;
    private boolean playerDead;




    public Player(Room firstRoom, double health){
        this.health = 5;
        this.maxHealth = health;
        currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
        this.playerDead = false;
    }


    public ArrayList<Item> getEquipped() {
        return equipped;
    }


    public Room getCurrentRoom(){
        return currentRoom;
    }


    public void increaseHealth(double increase) {
        health+= increase;


        if(health > maxHealth){
            health = maxHealth;
        }
    }


    public void decreaseHealth(double decrease) {
        health = getPlayerHealth() - (decrease);


        if (health < 0) {
            health = 0;
        }
    }


    public double getPlayerHealth() {
        return health;
    }
    public void playerHit(double playerHitDamage){
        health -= playerHitDamage;
    }

    public double eat (Food food){
        health += food.getHealth();


        if (health > 50){
            health = 50;
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

    public Item getCurrentEquippedItem(){
        return currentEquipped;
    }

    public Weapon getCurrentWeapon(){
        return currentEquipped;
    }

    public WeaponStatus equip(String weaponName){
        Item weaponEquip = findIteminventory(weaponName);
        if (weaponEquip == null) {
            return WeaponStatus.NOT_IN_INVENTORY;
        }
        if (weaponEquip instanceof Weapon) {
            Weapon weapon = (Weapon) weaponEquip;
//          inventory.remove(weapon);
            equipped.add(weapon);
            currentEquipped = weapon;
            return WeaponStatus.WEAPON;
        } else {
            return WeaponStatus.NOT_WEAPON;
        }
    }


    public WeaponStatus attack() {
        Weapon weapon = currentEquipped;
        if (weapon == null) {
            return WeaponStatus.NOTHING_EQUIPPED;
        } else if (weapon.canUse()) {
            weapon.use();
            return WeaponStatus.USED;
        } else {
            return WeaponStatus.NO_AMMO_LEFT;
        }
    }


    public FoodType eat (String foodName){
        Item itemToEat = findIteminventory(foodName);
        if (itemToEat == null) {
            itemToEat = currentRoom.findItem(foodName);
            if (itemToEat == null) {
                return FoodType.NOT_HERE;
            }
        }
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;
            if (food.getHealth() > 0) {
                increaseHealth(food.getHealth());
                inventory.remove(food);
                currentRoom.removeItem(food);
                return FoodType.GOOD;
            } else if (food.getHealth() < 0) {
                decreaseHealth(-food.getHealth());
                inventory.remove(food);
                currentRoom.removeItem(food);
                return FoodType.BAD;
            } else { //if (!(itemToEat instanceof Food))
                return FoodType.NOT_FOOD;
            }
        }
        return FoodType.NOT_FOOD;


    }

    public boolean isPlayerDead() {
        if (health < 0) {
           return playerDead = true;
        }
        return false;
    }
}
