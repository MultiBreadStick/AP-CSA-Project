package mainObjects;

public class Enemy {

    private int health;
    private double defense;
    private int speed;
    private double attackMultiplier;
    private String name;
    public boolean isDead;
    private boolean isRanged;
    private Attack enemyAttack;
    private int[] hitBox = {0, 0};
    
    public Enemy(int health, double defense, int speed, double attackMultiplier, String name, boolean isRanged, Attack enemyAttack) {
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.attackMultiplier = attackMultiplier;
        this.name = name;
        isDead = false;
        this.isRanged = isRanged;
        this.enemyAttack = enemyAttack;
        hitBox = new int[]
            {10, 10};
    }
    public Enemy(Enemy enemyE) {
        this.health = enemyE.getHealth();
        this.defense = enemyE.getDefense();
        this.speed = enemyE.getSpeed();
        this.attackMultiplier = enemyE.getAttackMultiplier();
        this.name = enemyE.getName();
        isDead = false;
        this.isRanged = enemyE.getIsRanged();
        this.enemyAttack = enemyE.getAttack();
        this.hitBox = getHitBox();
    }
    public Enemy(int health, double defense, int speed, double attackMultiplier, String name, boolean isRanged, Attack enemyAttack, int[] hitBox) {
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.attackMultiplier = attackMultiplier;
        this.name = name;
        isDead = false;
        this.isRanged = isRanged;
        this.enemyAttack = enemyAttack;
        this.hitBox = hitBox;
    }

    //Get, set health
    public int getHealth () {
        return health;
    } 
    public void setHealth (int health) {
        this.health = health;
    }
    
    /**
     * Gets the defense value of the enemy.
     *
     * @return the defense value of the enemy
     */
    public double getDefense() {
        return defense;
    }

    /**
     * Sets the defense value of the enemy.
     *
     * @param defense the new defense value of the enemy
     */
    public void setDefense(double defense) {
        this.defense = defense;
    }

    /**
     * Gets the speed of the enemy.
     *
     * @return the speed of the enemy
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the enemy.
     *
     * @param speed the new speed of the enemy
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets the attack multiplier of the enemy.
     *
     * @return the attack multiplier of the enemy
     */
    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    /**
     * Sets the attack multiplier of the enemy.
     *
     * @param attackMultiplier the new attack multiplier of the enemy
     */
    public void setAttackMultiplier(double attackMultiplier) {
        this.attackMultiplier = attackMultiplier;
    }

    /**
     * Gets the name of the enemy.
     *
     * @return the name of the enemy
     */
    public String getName() {
        return name; 
    }

    /**
     * Sets the name of the enemy.
     *
     * @param name the new name of the enemy
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * Checks if the enemy is dead.
     *
     * @return true if the enemy is dead, false otherwise
     */
    public boolean getIsDead() {
        return isDead;
    }
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    //get, set isRanged
    public boolean getIsRanged() {
        return isRanged;
    }

    public Attack getAttack() {
        return enemyAttack;
    }

    public int[] getHitBox() {
        return hitBox;
    }

    //get what enemy gets placed in what rooms
    public Enemy randomEnemy() {
        int i = (int)(Math.random() * 5);
        return switch (i) {
            case 0 -> Constants.crab;
            case 1 -> Constants.crab;
            case 2 -> Constants.crab;
            case 3 -> Constants.crab;
            case 4 -> Constants.crab;
            default -> null;
        };
    }
}
