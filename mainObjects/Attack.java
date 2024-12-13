package mainObjects;

/**
 * The Attack class represents an attack action in the game.
 * It contains information about the attack's damage, type, and other relevant properties.
 */
public class Attack {
    private int damage;
    private String type;
    private double accuracy;

    /**
     * Constructs an Attack with the specified damage, type, and accuracy.
     *
     * @param damage the damage value of the attack
     * @param type the type of the attack
     * @param accuracy the accuracy of the attack
     */
    public Attack(int damage, String type, double accuracy) {
        this.damage = damage;
        this.type = type;
        this.accuracy = accuracy;
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
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the attack.
     *
     * @param type the new type of the attack
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the accuracy of the attack.
     *
     * @return the accuracy of the attack
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Sets the accuracy of the attack.
     *
     * @param accuracy the new accuracy of the attack
     */
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
