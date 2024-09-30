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

//    public void movePlayer(String direction) {
//        player.move(direction);
//    }
//
        public String getCurrentRoomName() {
        return player.getCurrentRoom().getName();
    }

        public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getDescription();
    }


}