import java.util.ArrayList;
import java.util.List;

public class PlayerStats {
    //initialize variables 
    private int currentHealth;
    private int maxHealth; 
    private int experience; 
    private int level; 
    private String name; 
    private Weapon ranged;
    private Weapon short;

    // constructor
    public PlayerStats(String name)
    {
        this.name = name; 
        this.currentHealth = 100; 
        this.maxHealth = 100;
        this.experience = 0; 
        this.level = 1; 
        this.ranged = new Weapon();
        this.short = new Weapon();
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
    // (copilot)
    //public List<String> getInventory() {
    //    return inventory;
    //}

    // setters for everything that needs it
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
            ranged = item;
        } else short = item;
    }

    // remove item from inventory (copilot)
    public void removeItemFromInventory(Weapon item) {
        inventory.remove(item); 
    }

    //returns all of the player's information
    public String toString()
    {
        return "Name: " + name + "\n" + "Level: " + level + "\n" + "Experience: " + experience + "\n" + "Health: " + currentHealth + "/" + maxHealth + "\n" + "Weapon: " + weapon.toString();
    }
}

    

