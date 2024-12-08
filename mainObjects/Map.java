package mainObjects;

public class Map {
    //Instance variables
    private Room[][] map;
    private int stageLevel;

    
    //Constructor
    public Map(int level) {
        this.stageLevel = level;
        for (int i = 1; i < 5 ; i++) {
            for (int j = 1; j < 5; j++) {
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
} 
