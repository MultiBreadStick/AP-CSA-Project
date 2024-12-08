package mainObjects;

public class Map {
    //Instance variables
    private Room[][] map;
    private int stageLevel;

    
    //Constructor
    public Map(int level) {
        this.stageLevel = level;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int roomGen = (int)(Math.random() * 10);
                if (roomGen == 9) {
                    map[i][j] = new Room(stageLevel, false, "treasure");
                } else {
                    map[i][j] = new Room(stageLevel, false, "monster");
                }
            }
        }
        map[0][0] = new Room(stageLevel, true, "empty");
    }

    //move room
    public void nextRoomRight() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 4) {
                    map[i + 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomLeft() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 0) {
                    map[i - 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomUp() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && j != 4) {
                    map[i][j + 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomDown() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && j != 0) {
                    map[i][j - 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
} 
