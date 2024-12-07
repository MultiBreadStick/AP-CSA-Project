
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

    // constructor
    public PlayerStats(String name)
    {
        this.name = name; 
        currentHealth = 100; 
        maxHealth = 100;
        experience = 0; 
        level = 1;
        speed = 4; 
        hand1 = new Weapon();
        hand2 = new Weapon();
    }
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
    public int getCurrentHealth()
    {
        return currentHealth; 
    }
    public int getMaxHealth()
    {
        return maxHealth; 
    }
    public int getExperience()
    {
        return experience; 
    }
    public int getLevel()
    {
        return level; 
    }
    public int getSpeed() {
        return speed;
    }
    public Weapon getWeapon1()
    {
        return hand1; 
    }
    public Weapon getWeapon2() 
    {
        return hand2;
    }
    public String getName()
    {
        return name; 
    }

    public void setCurrentHealth(int currentHealth)
    {
        this.currentHealth = currentHealth; 
        if (currentHealth > maxHealth)
        {
            this.currentHealth = maxHealth; 
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //leveling up 
    public void levelingUp(int experience)
    {
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
    public String toString()
    {
        return "Name: " + name + "\n" + "Level: " + level + "\n" + "Experience: " + experience + "\n" + "Health: " + currentHealth + "/" + maxHealth + "\n" + "Weapon: " + hand1.toString() + " " + hand2.toString();
    }
}

    

