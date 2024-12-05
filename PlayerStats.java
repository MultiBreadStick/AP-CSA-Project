public class Playerstats {
    //initialize variables 
    private int currentHealth;
    private int maxHealth; 
    private int experience; 
    private int level; 
    private Weapon weapon; 
    private String name; 

    // constructor
    public Playerstats(String name)
    {
        this.name = name; 
        this.currenthealth = 100; 
        this.maxHealth = 100;
        this.experience = 0; 
        this.level = 1; 
        this.weapon = new Weapon(); 
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
    public Weapon getWeapon()
    {
        return weapon; 
    }
    public String getName()
    {
        return name; 
    }

    // setting the health 
    public void setCurrentHealth(int currentHealth)
    {
        this.currentHealth = currentHealth; 
        if (currentHealth > maxHealth)
        {
            this.currentHealth = maxHealth; 
        }
    }

    //leveling up 
    public void levelingUp(int experience)
    {
        this.experience += experience; 
        if (experience >= (level * 2))
        {
            this.experience = (experience - (level * 2));  
            level++; 
            maxHealth += 10; 
            currentHealth = maxHealth; 
        }
    }
}
