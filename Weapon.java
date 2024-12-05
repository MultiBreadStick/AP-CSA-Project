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


    // returns all of the weapon's information with help from Github Copilot
    public String toString() {
        return "This " + name + " has a damage multiplier of " + multiplier + " and a speed multiplier of " + weaponSpeed + " .";
    }
}