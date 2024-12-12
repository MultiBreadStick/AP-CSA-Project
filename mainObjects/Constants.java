package mainObjects;

public class Constants {
    
    //Room array
    public static final int ROOM_ROW_MAX = 5;
    public static final int ROOM_COL_MAX = 5;

    public static final int MAX_X = 16*120;
    public static final int MAX_Y = 9*120;

    //Crab
    //public static final Attack CRAB_ATTACK = new Attack(20, );
    //public static final Enemy crab = new Enemy(100, 0.75, 3, 1.25, "Crab", true);
    public static final int CRAB_MIN = 2;
    public static final int CRAB_MAX = 3;

    //Goblin
    //public static final Enemy goblin = new Enemy(50, 1, 6, 1, "Goblin", false);
    public static final int GOBLIN_MIN = 3;
    public static final int GOBLIN_MAX = 5;

    //Kiffe (yoked)
    //public static final Enemy kiffe = new Enemy(100, 1, 4, 1.25, "Kiffe", false);
    public static final int KIFFE_MIN = 2;
    public static final int KIFFE_MAX = 3;

    //Giant
    //public static final Enemy giant = new Enemy(200, 1.25, 3, 1.25, "Giant", false);
    public static final int GIANT_MIN = 1;
    public static final int GIANT_MAX = 2;

    //Big rock
    //public static final Enemy bigRock = new Enemy(150, 0.75, 2, 0.75, "Big Rock", false);
    public static final int BIG_ROCK_MIN = 1;
    public static final int BIG_ROCK_MAX = 2;



    //Sword
    public static final Weapon sword = new Weapon(1.5, 1.5, "Sword", false);

    //Hammer
    public static final Weapon hammer = new Weapon(3, 0.75, "Hammer", false);

    //Bow
    public static final Weapon bow = new Weapon(1.25, 1.25, "Bow", true);

    //Spells
    public static final Weapon spell = new Weapon(1.5, 1, "Spell", true);

    //empty
    public static final Weapon empty = new Weapon();



    //Warrior
    public static final PlayerStats warrior = new PlayerStats(125, 4, "Koo", sword, empty);

    //Archer
    public static final PlayerStats archer = new PlayerStats(90, 6, "Koo", empty, bow);

    //Sorcerer
    public static final PlayerStats sorcerer = new PlayerStats(75, 5, "Koo", empty, spell);
}
