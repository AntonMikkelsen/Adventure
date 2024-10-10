import java.io.ObjectInputStream;
import java.util.Scanner;

public class Adventure {
    private Map map;
    Player player;

    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom(), 50);
    }

    public Player getPlayer() {
        return player;
    }

    public Room move(String direction) {
        return player.move(direction);
    }

    public String getCurrentRoomName() {
        return player.getCurrentRoom().getName();
    }

    public double getPlayerHealth(){
        return player.getPlayerHealth();
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }


    public String eat(String foodName) {
        FoodType status = player.eat(foodName);
        return switch (status) {
            case GOOD -> "You ate the " + foodName + "!" + " You gained " + getPlayerHealth() + " healthpoints.";
            case BAD -> "That wasn't good..." + "you just lost health :( Current health:" + getPlayerHealth() + " healthpoints";
            case NOT_FOOD -> "You cannot eat that!";
            case NOT_HERE -> "There is no such thing as " + foodName + " in your inventory or in this room.";
            default -> "Invalid input!";
        };
    }


    public String equip(String equipmentName) {
        WeaponStatus status = player.equip(equipmentName);
        return switch (status) {
            case WEAPON -> "you equipped" + equipmentName + player.getCurrentEquippedItem();
            case NOT_WEAPON -> "this item is not a weapon, it can therefore not be equipped";
            case NOT_IN_INVENTORY -> "you need to pick up the item before you can equip it";
            default -> "invalid input";
        };
    }

    public Enemy seeEnemies(){
        for (Enemy enemy : player.getCurrentRoom().getEnemies()){
            return enemy;
        }
        return null;
    }


    public Item seeCurrentEquipped() {
        return player.getCurrentEquippedItem();
    }

    public String attack(Enemy enemy) {
        WeaponStatus status = player.attack();
        switch (status) {
            case NOTHING_EQUIPPED:
                return "Nothing is equipped so you cannot attack";

            case USED:
                enemy.hit(player.getCurrentWeapon().getDamage());
                player.playerHit(enemy.getWeapon().getDamage());

               if (enemy.getHealth() < 1) {
                    Item droppedWeapon = enemy.getWeapon();
                      player.getCurrentRoom().addItem(droppedWeapon);
                      player.getCurrentRoom().removeEnemy(enemy);
                      return "You just used the " + seeCurrentEquipped().getName() + " and dealt "
                              + player.getCurrentWeapon().getDamage() +
                              " damage to the " + enemy.getName() + ". Yet " + enemy.getName() + " retaliates, striking back dealing: "
                              + enemy.getWeapon().getDamage() + " damage!" +
                              "\nYou defeated the enemy and it dropped a " + droppedWeapon.getName() +
                              "\n The battle was fierce, you now have " + getPlayerHealth() + " HP left.";
               }
               return "You just used the " + seeCurrentEquipped().getName() + " and dealt "
                            + player.getCurrentWeapon().getDamage() +
                            " damage to the " + enemy.getName() + ". But the " + enemy.getName() + " strikes back dealing: "
                            + enemy.getWeapon().getDamage() + " damage!" +
                            "\nYou now have " + getPlayerHealth() + " HP left.";


            case NO_AMMO_LEFT:
                return "No uses left.";
            default:

                return "invalid input!";
        }

    }

    public boolean playerDead() {
        if(player.getPlayerHealth() <= 0){
            return true;
        }else {
            return false;
        }
    }
}
