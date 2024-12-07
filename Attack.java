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
    public int getEnemyAttackDamage(Enemy enemy) {
        return (int)(damage * weapon.getMultiplier() * enemy.getAttackMultiplier());
    }
    public int getPlayerAttackDamage() {
        return (int)(damage * weapon.getMultiplier());
    }
    public String getAttackName() {
        return name;
    }
    public void setAttackName(String name) {
        this.name = name; 
    }
    //to string
    //public String toString() {
    //    return getAttackName() + " does " + getEnemyAttackDamage() + " damage!";
    //}
}
