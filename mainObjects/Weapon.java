package mainObjects;

public class Weapon {
    private double multiplier;
    private double weaponSpeed;
    private String name;
    private boolean isRanged;
    private int[] attackArea;

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
        attackArea = new int[]{10, 10};
    }
    public Weapon(double multiplier, double weaponSpeed, String name, boolean isRanged, int[] attackArea) {
        this.multiplier = multiplier;
        this.weaponSpeed = weaponSpeed;
        this.name = name;
        this.isRanged = isRanged;
        this.attackArea = attackArea;
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

    public int[] getAttackArea() {
        return attackArea;
    }
    
    public void setAttackArea(int[] attackArea) {
        this.attackArea = attackArea;
    }
    
    @Override
    public String toString() {
        return "This " + name + " has a damage multiplier of " + multiplier + " and a speed multiplier of " + weaponSpeed + " .";
    }
}
