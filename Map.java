public class Map {
    //Instance variables
    private Room[ROOM_ROW_MAX][ROOM_COL_MAX] map;
    private int level;
    
    //Constructor
    public Map(int level) {
        this.level = level;
        for (int i = 0; i <ROOM_ROW_MAX ; i++) {
            for (int j = 0; j < ROOM_COL_MAX; j++) {
                int roomGen = (int)(Math.random()*10);
                if (roomGen == 9) {
                    map[i][j] = new Room(level, false, "treasure");
                } else {
                    map[i][j] = new Room(level, false, "monster");
                }
            }
        }
        map[0][0] = new Room(level, true, "empty");
    }
} 