package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import mainObjects.Enemy;
import mainObjects.Constants;


public class EnemyAI extends Entity {
    public Enemy enemy;
    GamePanel gp;
    int frameCounter;
    private int spriteCounter3 = 0;
	public Enemy thisEnemy = new Enemy(Constants.crab);

    

    public EnemyAI(int x, int y, Enemy enemy, GamePanel gp) {
        this.gp = gp;
        this.enemy = enemy;
        this.x = x;
        this.y = y;
        getEnemyImage();
		direction = "down";
    }

    public void setDefualtValues() {
        
    }
	

    public void enemyMovement(Player player) {
        frameCounter++;
        if(frameCounter>= 20){
            frameCounter = 0;
        }
        
        int playerChangeX = player.x - x;
        int playerChangeY = player.y - y;
        double distance = Math.sqrt(playerChangeX * playerChangeX + playerChangeY * playerChangeY);
        if(Math.abs(distance)<500){
            if (!(player.x == x && player.y == y)) {
                x += 3*((double)playerChangeX/distance);
                y += 3*((double)playerChangeY/distance);
            }
        }else{
            if(frameCounter == 0){
            }
        }
        
        if (playerChangeX > 0) {
			direction = "left";
		} else if (playerChangeX < 0) {
			direction = "right";
		} else if (playerChangeY > 0) {
			direction = "up";
		} else if (playerChangeY < 0) {
			direction = "down";
		}
		if(x == player.x && y == player.y){
			thisEnemy.isDead = true;
		}

		spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			spriteCounter3++;
			if(spriteCounter3 > 48) {
				spriteCounter3 = 0;
			}
			
    }

    public void getEnemyImage() {
        try {
			up1 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			up2 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			up3 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			down1 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			down2 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			down3 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			right1 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			right2 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			right3 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			left1 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			left2 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
			left3 = ImageIO.read(new File("Sprites/HazmatGuy/pingas guy.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up2;
			}if(spriteNum == 2) {
				image = up3;
			}else{
				image = up1;
			}
			break;
            case "down":
			if(spriteNum == 1) {
				image = down2;
			}if(spriteNum == 2) {
				image = down3;
			}else{
				image = down1;
			}
			break;
            case "left":
			if(spriteNum == 1) {
				image = left2;
			}if(spriteNum == 2) {
				image = left3;
			}else{
				image = left1;
			}
			break;
            case "right":
			if(spriteNum == 1) {
				image = right2;
			}if(spriteNum == 2) {
				image = right3;
			}else{
				image = right1;
			}
			break;
		}
		g2.drawImage(image, x, y, 4*gp.tileSize, 4*gp.tileSize, null);
    }
}
