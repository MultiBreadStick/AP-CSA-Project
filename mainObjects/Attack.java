package mainObjects;

public class Attack {
    //instance declaration
    private int damage;
    private Weapon weapon;
    private int width;
    private int length;
    
    //constructors
    public Attack(int damage, Weapon weapon, int width, int length) {
        this.damage = damage;
        this.name = name;
        this.weapon = weapon;
        this.width = width;
        this.length = length;
    }
    public Attack(int damage, int width, int length) {
        this.damage = damage;
    }
    
    //getter/setters
    public int getEnemyAttackDamage(Enemy enemy) {
        return (int)(damage * weapon.getMultiplier() * enemy.getAttackMultiplier() * (int)(Math.random() * 5));
    }
    public int getPlayerAttackDamage(Enemy enemy) {
        return (int)(damage * weapon.getMultiplier() * enemy.getDefense() * (int)(Math.random() * 5));
    }
    public String getAttackName() {
        return name;
    }
    public void setAttackName(String name) {
        this.name = name; 
    }
    
}
