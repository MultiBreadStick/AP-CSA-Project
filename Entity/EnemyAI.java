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
        if (!(player.x == x && player.y == y)) {
            int playerChangeX = player.x - x;
            int playerChangeY = player.y - y;
            double distance = Math.sqrt(playerChangeX * playerChangeX + playerChangeY * playerChangeY);
            x += 3*((double)playerChangeX/distance);
            y += 3*((double)playerChangeY/distance);
        }
        
    }

    public void getEnemyImage() {
        try {
            enemySprite = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(enemySprite, x, y, 4*gp.tileSize, 4*gp.tileSize, null);
    }
}
