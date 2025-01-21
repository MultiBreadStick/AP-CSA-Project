package mainObjects;


public class Attack {
    private int damage;
    private String name;
    private int[] hitBox;

    public Attack(int damage, String name, int[] hitBox) {
        this.damage = damage;
        this.name = name;
        this.hitBox = hitBox;
    }

    public int getEnemyAttackDamage(Enemy enemy) {
        return (int)(damage * enemy.getAttackMultiplier() * (int)(Math.random() * 5));
    }

    public int getPlayerAttackDamage(Enemy enemy, Weapon player) {
        return (int)(damage * player.getMultiplier() * enemy.getDefense() * (int)(Math.random() * 5));
    }
    
    public int getDamage() {
        return damage;
    }

    
    public void setDamage(int damage) {
        this.damage = damage;
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public int[] getWidth() {
        return hitBox;
    }
    public void setWidth(int[] hitBox) {
        this.hitBox = hitBox;
    }
} 
