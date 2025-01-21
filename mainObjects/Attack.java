package mainObjects;


public class Attack {
    private int damage;
    private String name;
    private int width;
    private int length;

    public Attack(int damage, String name, int width, int length) {
        this.damage = damage;
        this.name = name;
        this.width = width;
        this.length = length;
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

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
} 
