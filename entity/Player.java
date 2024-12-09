package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import mainObjects.Map;
import mainObjects.Room;
import mainObjects.PlayerStats

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	public Map map;
	public PlayerStats player;
	
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
		speed = player.getSpeed();
		direction = "down";
	}
	//Acesses the sprite files and defines the coresponding directions
	// the try catch is just in case the sprite files do not exist in the referenced location and cannot be acessed
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			up2 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			down1 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			down2 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			right1 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			right2 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			left1 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
			left2 = ImageIO.read(new File("entity/playerSprites/sprite.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// checks which keys are being pressed if any based off the key handler class and sets the sprite's corresponding direction
	// then cycles through each sprite( 2 for each direction) every 12 frames to create the running animaiton
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if((keyH.upPressed == true && keyH.downPressed == true) || (keyH.rightPressed == true && keyH.leftPressed == true)) {
				direction = "down";
			} else if(keyH.upPressed == true && keyH.leftPressed == true) {
				direction = "up";
				y -= (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.upPressed == true && keyH.rightPressed == true) {
				direction = "up";
				y -= (int) Math.round(((double)speed / 1.4142));
				x += (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.downPressed == true && keyH.leftPressed == true) {
				direction = "down";
				y += (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			}else if(keyH.downPressed == true && keyH.rightPressed == true) {
				direction = "down";
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

			//Boundary wall
			//Good enough for now but i need to figure out debugging menu
			if (x >= 992) {
				x = 992;
			} else if (x <= 160) {
				x = 160;
			}
			if (y >= 608) {
				y = 608;
			} else if (y <= 160) {
				y = 160;
			}

			//Next Room
			//Dead code for now until map is fully figured out
			if (x <= 575 && x >= 475 && y == 50) {
				map.nextRoomUp();
			} else if (x <= 575 && x >= 475 && y == 680) {
				map.nextRoomDown();
			} else if (y <= 390 && y >=290 && x == 50) {
				map.nextRoomLeft();
			} else if (y <= 390 && y >=290 && x == 1050) {
				map.nextRoomRight();
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
		}
		
	}
	// this sets which image the player sprite is supposed to be using a switch statment based off our update() method
	// then it actually draws the player onto the screen in whatever location its supposed to be in
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
