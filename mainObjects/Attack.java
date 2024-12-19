package mainObjects;

/**
 * The Attack class represents an attack action in the game.
 * It contains information about the attack's damage, type, and other relevant properties.
 */
public class Attack {
    private int damage;
    private String name;
    private int width;
    private int length;
    /**
     * Constructs an Attack with the specified damage, type, and accuracy.
     *
     * @param damage the damage value of the attack
     * @param type the type of the attack
     * @param accuracy the accuracy of the attack
     */
    public Attack(int damage, String name, int width, int length) {
        this.damage = damage;
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public int getEnemyAttackDamage(Enemy enemy) {
        return (int)(damage * enemy.getAttackMultiplier() * (int)(Math.random() * 5));
    }

    public int getPlayerAttackDamage(Enemy enemy, Weapon player) {
        return (int)(damage * player.getMultiplier() * enemy.getDefense() * (int)(Math.random() * 5));
    }
    /**
     * Gets the damage value of the attack.
     *
     * @return the damage value of the attack
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage value of the attack.
     *
     * @param damage the new damage value of the attack
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Gets the type of the attack.
     *
     * @return the type of the attack
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the type of the attack.
     *
     * @param type the new type of the attack
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
} 
