package mainObjects;

/**
 * The Room class represents a room in the game.
 */
public class Room {
    private int level;
    private boolean inRoom;
    private String type;
    private int numEnemies;

    /**
     * Constructs a Room with the specified level, inRoom status, type, and number of enemies.
     *
     * @param level the level of the room
     * @param inRoom whether the player is in the room
     * @param type the type of the room
     * @param numEnemies the number of enemies in the room
     */
    public Room(int level, boolean inRoom, String type, int numEnemies) {
        this.level = level;
        this.inRoom = inRoom;
        this.type = type;
        this.numEnemies = numEnemies;
    }

    /**
     * Gets the level of the room.
     *
     * @return the level of the room
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the room.
     *
     * @param level the new level of the room
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Checks if the player is in the room.
     *
     * @return true if the player is in the room, false otherwise
     */
    public boolean getInRoom() {
        return inRoom;
    }

    /**
     * Sets the inRoom status of the room.
     *
     * @param inRoom the new inRoom status of the room
     */
    public void setInRoom(boolean inRoom) {
        this.inRoom = inRoom;
    }

    /**
     * Gets the type of the room.
     *
     * @return the type of the room
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the room.
     *
     * @param type the new type of the room
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the number of enemies in the room.
     *
     * @return the number of enemies in the room
     */
    public int getNumEnemies() {
        return numEnemies;
    }

    /**
     * Sets the number of enemies in the room.
     *
     * @param numEnemies the new number of enemies in the room
     */
    public void setNumEnemies(int numEnemies) {
        this.numEnemies = numEnemies;
    }
}
