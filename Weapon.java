public class Weapon {
    private double multiplier;
    private double weaponSpeed;
    private String name;

    public Weapon() {
        multiplier = 1.0;
        weaponSpeed = 2.0;
        name = "Bare Hands";
    }

    public Weapon(double multiplier, double weaponSpeed, String name, String type) {
        this.multiplier = multiplier;
        this.weaponSpeed = weaponSpeed;
        this.name = name;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getSpeedMultiplier() {
        return weaponSpeed;
    }

    // changes the weapon's name
    public void changeWeaponName(String name) {
        this.name = name;
    }

    // returns all of the weapon's information with help from Github Copilot
    public String toString() {
        return "This " + name + " has a damage multiplier of " + multiplier + " and a speed multiplier of " + weaponSpeed + " .";
    }
}