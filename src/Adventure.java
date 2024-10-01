import java.util.Scanner;

public class Adventure {
    private Map map;
    private Player player;

    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom());
    }

    public Player getPlayer() {

        return player;
    }

    public String move(String direction) {
        Room rum = player.move(direction);
        if (rum != null) {
            return "You have just moved to " + player.getCurrentRoom().getName() + " " + player.getCurrentRoom().getDescription();
        } else {
            return "You cannot go that way";
        }
    }

    public String getCurrentRoomName() {
        return player.getCurrentRoom().getName();
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }
}

