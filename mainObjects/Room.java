package mainObjects;



public class Room {
    private int level;
    private boolean inRoom;
    private String type;
    private int numEnemies;

    public Room(int level, boolean inRoom, String type, int numEnemies) {
        this.level = level;
        this.inRoom = inRoom;
        this.type = type;
        this.numEnemies = numEnemies;
    }

    //get set
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public boolean getInRoom() {
        return inRoom;
    }
    
    public void setInRoom(boolean inRoom) {
        this.inRoom = inRoom;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
