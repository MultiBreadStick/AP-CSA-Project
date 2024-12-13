package mainObjects;

public class Weapon {
    private double multiplier;
    private double weaponSpeed;
    private String name;
    private boolean isRanged;

    public Weapon() {
        multiplier = 1.0;
        weaponSpeed = 2.0;
        name = "Bare Hands";
        isRanged = false;
    }

    public Weapon(double multiplier, double weaponSpeed, String name, boolean isRanged) {
        this.multiplier = multiplier;
        this.weaponSpeed = weaponSpeed;
        this.name = name;
        this.isRanged = isRanged;
    }

    // set get methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * Gets the speed of the weapon.
     *
     * @return the speed of the weapon
     */
    public double getWeaponSpeed() {
        return weaponSpeed;
    }

    /**
     * Sets the speed of the weapon.
     *
     * @param weaponSpeed the new speed of the weapon
     */
    public void setWeaponSpeed(double weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }

    /**
     * Checks if the weapon is ranged.
     *
     * @return true if the weapon is ranged, false otherwise
     */
    public boolean getIsRanged() {
        return isRanged;
    }

    /**
     * Sets whether the weapon is ranged.
     *
     * @param isRanged true if the weapon is ranged, false otherwise
     */
    public void setIsRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }

    /**
     * Returns a string representation of the weapon's information.
     *
     * @return a string containing the weapon's name, damage multiplier, and speed multiplier
     */
    @Override
    public String toString() {
        return "This " + name + " has a damage multiplier of " + multiplier + " and a speed multiplier of " + weaponSpeed + " .";
    }
}
