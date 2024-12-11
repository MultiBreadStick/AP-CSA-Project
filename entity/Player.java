package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import mainObjects.Constants;
import mainObjects.Map;
import mainObjects.PlayerStats;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	public Map map;
	public PlayerStats player;
	private boolean keyPressed;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPlayerImage();
	}
	//Sets the player starting position, move speed, and direction of movment and sprite
	public void setDefaultValues() {
		x = 496;
		y = 284;
		speed = 4;
		direction = "down";
	}
	//Acesses the sprite files and defines the coresponding directions
	// the try catch is just in case the sprite files do not exist in the referenced location and cannot be acessed
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(new File("Sprites/HazmatGuy/21.png"));
			up2 = ImageIO.read(new File("Sprites/HazmatGuy/22.png"));
			up3 = ImageIO.read(new File("Sprites/HazmatGuy/23.png"));
			down1 = ImageIO.read(new File("Sprites/HazmatGuy/11.png"));
			down2 = ImageIO.read(new File("Sprites/HazmatGuy/12.png"));
			down3 = ImageIO.read(new File("Sprites/HazmatGuy/13.png"));
			right1 = ImageIO.read(new File("Sprites/HazmatGuy/31.png"));
			right2 = ImageIO.read(new File("Sprites/HazmatGuy/32.png"));
			right3 = ImageIO.read(new File("Sprites/HazmatGuy/33.png"));
			left1 = ImageIO.read(new File("Sprites/HazmatGuy/41.png"));
			left2 = ImageIO.read(new File("Sprites/HazmatGuy/42.png"));
			left3 = ImageIO.read(new File("Sprites/HazmatGuy/43.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// checks which keys are being pressed if any based off the key handler class and sets the sprite's corresponding direction
	// then cycles through each sprite( 2 for each direction) every 12 frames to create the running animaiton
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			keyPressed = true;
			if((keyH.upPressed == true && keyH.downPressed == true) || (keyH.rightPressed == true && keyH.leftPressed == true)) {
			} else if(keyH.upPressed == true && keyH.leftPressed == true) {
				direction = "left";
				y -= (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.upPressed == true && keyH.rightPressed == true) {
				direction = "right";
				y -= (int) Math.round(((double)speed / 1.4142));
				x += (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.downPressed == true && keyH.leftPressed == true) {
				direction = "left";
				y += (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			}else if(keyH.downPressed == true && keyH.rightPressed == true) {
				direction = "right";
				y += (int) Math.round(((double)speed / 1.4142));
				x += (int) Math.round(((double)speed / 1.4142));
			}else if(keyH.upPressed == true) {
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

			//Next Room
			//Dead code for now until map is fully figured out
			if (x <= 970 && x >= 900 && y == 140) {
				map.nextRoomUp();
			} else if (x <= 970 && x >= 970 && y == 680) {
				map.nextRoomDown();
			} else if (y <= 390 && y >= 450 && x == 50) {
				map.nextRoomLeft();
			} else if (y <= 0 && y >= 450 && x == 1740) {
				map.nextRoomRight();
			}

			//Boundary wall
			//Good enough for now but i need to figure out debugging menu
			if (x >= Constants.MAX_X-180) {
				x = Constants.MAX_X-180;
			} else if (x <= 100) {
				x = 100;
			}
			if (y >= Constants.MAX_Y-130-192) {
				y = Constants.MAX_Y-130-192;
			} else if (y <= 150-192) {//wall size minus player
				y = 150-192;
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
		}else{
			keyPressed = false;
		}
		
	}
	// this sets which image the player sprite is supposed to be using a switch statment based off our update() method
	// then it actually draws the player onto the screen in whatever location its supposed to be in
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(keyPressed){
				if(spriteNum == 1) {
				image = up2;
				}if(spriteNum == 2) {
				image = up3;
			}
			}else{
				image = up1;
			}
			break;
		case "down":
			if(keyPressed){
				if(spriteNum == 1) {
				image = down2;
				}if(spriteNum == 2) {
				image = down3;
			}
			}else{
				image = down1;
			}
			break;
		case "left":
			if(keyPressed){
				if(spriteNum == 1) {
				image = left2;
				}if(spriteNum == 2) {
				image = left3;
			}
			}else{
				image = left1;
			}
			break;
		case "right":
			if(keyPressed){
				if(spriteNum == 1) {
				image = right2;
				}if(spriteNum == 2) {
				image = right3;
			}
			}else{
				image = right1;
			}
			break;
		}
		g2.drawImage(image, x, y, 4*gp.tileSize, 4*gp.tileSize, null);

	}
}
