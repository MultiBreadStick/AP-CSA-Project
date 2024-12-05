package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
    //initiates the player character within the game window and with the key lister
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPlayerImage();
	}
    //sets the starting position for the player character
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
    //The code is only made for a player with four directions and 2 sprites for the running animation
	public void getPlayerImage() {
		try {
            //we need images from a file in the "" for the sprites
			up1 = ImageIO.read(getClass().getResourceAsStream(""));
			up2 = ImageIO.read(getClass().getResourceAsStream(""));
			down1 = ImageIO.read(getClass().getResourceAsStream(""));
			down2 = ImageIO.read(getClass().getResourceAsStream(""));
			right1 = ImageIO.read(getClass().getResourceAsStream(""));
			right2 = ImageIO.read(getClass().getResourceAsStream(""));
			left1 = ImageIO.read(getClass().getResourceAsStream(""));
			left2 = ImageIO.read(getClass().getResourceAsStream(""));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
    //updates the character based on the key reader class
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
			}else if (keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}else if (keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}else if (keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			
            //rotates the sprites to animate the character
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
	}
    //actually draws the character on the screen
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

	}
}
