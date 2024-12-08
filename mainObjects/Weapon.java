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

    public double getWeaponSpeed() {
        return weaponSpeed;
    }
    public void setWeaponSpeed(double weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }

    public boolean getIsRanged() {
        return isRanged;
    }
    public void setIsRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }


    // returns all of the weapon's information with help from Github Copilot
    public String toString() {
        return "This " + name + " has a damage multiplier of " + multiplier + " and a speed multiplier of " + weaponSpeed + " .";
    }
}
