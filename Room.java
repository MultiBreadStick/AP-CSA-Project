public class Room {
    private int level;
    private boolean inRoom;
    private int type;

    public Room(int level, boolean inRoom, int type) {
        this.level = level;
        this.inRoom = inRoom;
        this.type = type;
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

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }



}
