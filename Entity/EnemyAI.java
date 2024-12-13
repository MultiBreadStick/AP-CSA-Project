package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import mainObjects.Enemy;


public class EnemyAI {
    int x, y;
    public BufferedImage enemySprite;
    public Enemy enemy;
    GamePanel gp;

    

    public EnemyAI(int x, int y, Enemy enemy, GamePanel gp) {
        this.gp = gp;
        this.enemy = enemy;
        this.x = x;
        this.y = y;
        getEnemyImage();
    }

    public void enemyMovement(Player player) {
        int playerChangeX = player.x - x;
        int playerChangeY = player.y - y;
        double distance = Math.sqrt(playerChangeX * playerChangeX + playerChangeY * playerChangeY);
        x += 3*(int)((double)playerChangeX/distance);
        y += 3*(int)((double)playerChangeY/distance);
    }

    public void getEnemyImage() {
        try {
            enemySprite = ImageIO.read(new File("Entity/playerSprites/sprite.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(enemySprite, x, y, 2*gp.tileSize, 2*gp.tileSize, null);
    }
}
