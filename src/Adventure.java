import java.util.Scanner;


public class Adventure {
    private Map map;
    Player player;


    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom(), 100);
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


    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }

    public String eat(String foodName) {
        FoodType status = player.eat(foodName);
        switch (status) {
            case GOOD:
                return "You ate the " + foodName + "!" + " You gained " + player.getHealth() + " healthpoints.";
            case BAD:
                return "That wasn't good..." + "you just lost health :( Current health:" + player.getHealth() + " healthpoints";
            case NOT_FOOD:
                return "You cannot eat that!";
            case NOT_HERE:
                return "There is no such thing as " + foodName + " in your inventory or in this room.";

            default:
                return "Invalid input!";

        }
    }
}