package mainObjects;

/**
 * The PlayerStats class represents the statistics of a player in the game.
 */
public class PlayerStats {
    //initialize variables 
    private int currentHealth;
    private int maxHealth; 
    private int experience; 
    private int level; 
    private int speed;
    private String name; 
    private Weapon hand1;
    private Weapon hand2;

    /**
     * Default constructor for PlayerStats.
     * Initializes the player with default values.
     */
    public PlayerStats() {
        name = "Koo"; 
        currentHealth = 100; 
        maxHealth = 100;
        experience = 0; 
        level = 1;
        speed = 4; 
        hand1 = new Weapon();
        hand2 = new Weapon();
    }

    /**
     * Parameterized constructor for PlayerStats.
     * 
     * @param maxHealth the maximum health of the player
     * @param speed the speed of the player
     * @param name the name of the player
     * @param hand1 the weapon in the player's first hand
     * @param hand2 the weapon in the player's second hand
     */
    public PlayerStats(int maxHealth, int speed, String name, Weapon hand1, Weapon hand2) {
        currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        experience = 0;
        level = 1;
        this.speed = speed;
        this.name = name;
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    // getters
    /**
     * Gets the current health of the player.
     *
     * @return the current health of the player
     */
    public int getCurrentHealth() {
        return currentHealth; 
    }

    /**
     * Gets the maximum health of the player.
     *
     * @return the maximum health of the player
     */
    public int getMaxHealth() {
        return maxHealth; 
    }

    /**
     * Gets the experience of the player.
     *
     * @return the experience of the player
     */
    public int getExperience() {
        return experience; 
    }

    /**
     * Gets the level of the player.
     *
     * @return the level of the player
     */
    public int getLevel() {
        return level; 
    }

    /**
     * Gets the speed of the player.
     *
     * @return the speed of the player
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the weapon in the player's first hand.
     *
     * @return the weapon in the player's first hand
     */
    public Weapon getWeapon1() {
        return hand1; 
    }

    /**
     * Gets the weapon in the player's second hand.
     *
     * @return the weapon in the player's second hand
     */
    public Weapon getWeapon2() {
        return hand2;
    }

    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name; 
    }

    /**
     * Sets the current health of the player.
     *
     * @param currentHealth the new current health of the player
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth; 
        if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth; 
        }
    }

    /**
     * Sets the name of the player.
     *
     * @param name the new name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the speed of the player.
     *
     * @param speed the new speed of the player
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //leveling up 
    /**
     * Levels up the player based on the given experience.
     *
     * @param experience the experience points to level up the player
     */
    public void levelingUp(int experience) {
        this.experience += experience;
        while (this.experience >= (level * 2)) {
            this.experience -= (level * 2);
            level++;
            maxHealth += 10;
            currentHealth = maxHealth;
        }
    }

    public void addItemToInventory(Weapon item) {
        if (item.getIsRanged()); {
            hand2 = item;
        } if (!item.getIsRanged()){  //else statement didn't work for some reason
            hand1 = item;
        }
    }

    //returns all of the player's information
    public String toString() {
        return "Name: " + name + "\n" + "Level: " + level + "\n" + "Experience: " + experience + "\n" + "Health: " + currentHealth + "/" + maxHealth + "\n" + "Weapon: " + hand1.toString() + " " + hand2.toString();
    }
}
