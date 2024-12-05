public class Attack {
    //instance declaration
    private int damage;
    private String name;
    private Weapon weapon;
    //constructors
    public Attack(int damage, String name, Weapon weapon) {
        this.damage = damage;
        this.name = name;
        this.weapon = weapon;
    }
    //getter/setters
    public double getEnemyAttackDamage(Enemy enemy) {
        return damage * weapon.getMultiplier() * enemy.getAttackMultiplier();
    }
    public double getPlayerAttackDamage() {
        return damage * weapon.getMultiplier();
    }
    public String getAttackName() {
        return name;
    }
    public void setAttackName(String name) {
        this.name = name; 
    }
    //to string
    public String toString() {
        return getAttackName() + " does " + getAttackDamage() + " damage!";
    }
}