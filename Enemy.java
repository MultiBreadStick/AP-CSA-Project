
public class Enemy {

    private int health;
    private double defense;
    private double speed;
    private double attackMultiplier;
    private String name;
    private boolean isDead;
    private boolean isRanged;
    
    public Enemy(int health, double defense, double speed, double attackMultiplier, String name, String type, boolean isRanged) {
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.attackMultiplier = attackMultiplier;
        this.name = name;
        isDead = false;
        this.isRanged = isRanged;
    }
    
    //Get, set health
    public int getHealth () {
        return health;
    } 
    public void setHealth (int health) {
        this.health = health;
    }
    
    //Get, set defense
    public double getDefense () {
        return defense;
    }
    public void setDefense (double defense) {
        this.defense = defense;
    }

    //Get, set speed
    public double getSpeed () {
        return speed;
    }
    public void setSpeed (double speed) {
        this.speed = speed;
    }

    //Get, set attackMultiplier
    public double getAttackMultiplier () {
        return attackMultiplier;
    }
    public void setAttackMultiplier (double attackMultiplier) {
        this.attackMultiplier = attackMultiplier;
    }

    //Get, set name
    public String getName() {
        return name; 
    }
    public void setName (String name) {
        this.name = name;
    }

    //Get, set isDead
    public boolean getIsDead() {
        return isDead;
    }
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    //get, set isRanged
    public boolean isRanged() {
        return isRanged;
    }

    //get what enemy gets placed in what rooms
    public int randomEnemy() {
        return (int)(Math.random() * 6)
    }
}