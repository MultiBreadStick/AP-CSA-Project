package Entity;

import mainObjects.Enemy;
import java.awt.image.BufferedImage;

public class EnemyAI {
    //chatgpt helped start
    int x, y;
    public BufferedImage enemySprite ;
    public Enemy enemy;
    

    public EnemyAI(int x, int y, Enemy enemy) {
        this.enemy = enemy;
        this.x = x;
        this.y = y;
    }

    public void enemyMovement(Player player) {
        int playerChangeX = player.x - x;
        int playerChangeY = player.y - y;
        double distance = Math.sqrt(playerChangeX * playerChangeX + playerChangeY * playerChangeY);
        x = (int)((double)playerChangeX/distance);
        y = (int)((double)playerChangeY/distance);
    }
}
