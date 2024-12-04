
public class Enemies {

    private int health;
    private int defense;
    private double speed;
    private String name;
    
    public Enemies(int health, int defense, double speed, String name, String type) {
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.name = name;
    }
    
    //Get, set health
    public int getHealth () {
        return health;
    } 
    public void setHealth (int health) {
        this.health = health;
    }
    
    //Get, set defense
    public int getDefense () {
        return defense;
    }
    public void setDefense (int defense) {
        this.defense = defense;
    }

    //Get, set speed
    public double getSpeed () {
        return speed;
    }
    public void setSpeed (double speed) {
        this.speed = speed;
    }

    //Get, set name
    public String getName() 
    {
        return name; 
    }
() {
        return name;
    }
    public void setName () {
        this.name = name;
    }
}