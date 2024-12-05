public class Weapon {
    private double multiplier;
    private String name;
    private String type;

    public Weapon() {
        multiplier = 1;
        name = "Bare Hands";
        type = "Bare Hands";
    }

    // getter methods
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    // changes the weapon's name
    public void changeWeaponName(String name) {
        this.name = name;
    }

    // returns all of the weapon's information with help from Github Copilot
    public String toString() {
        return "This " + type + " is named: " + name + ". " + name + " has a damage multiplier of " + multiplier + ".";
    }
}