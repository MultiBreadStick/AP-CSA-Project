package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;
import main.sounds;
import mainObjects.Constants;
import mainObjects.Map;
import mainObjects.PlayerStats;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	MouseHandler mouseH;
	public Map map;
	public PlayerStats player;
	private boolean keyPressed;
	private int spriteCounterMovement3 = 0;
	private int spriteCounterAttack3 = 0;
	private boolean isAttack;
	sounds sound = new sounds();
	sounds breathSound = new sounds();
	
	public Player(GamePanel gp, KeyHandler keyH, MouseHandler mouseH) {
		this.gp = gp;
		this.keyH = keyH;
		this.mouseH = mouseH;
		this.map = gp.map;
		setDefaultValues();
		getPlayerImage();
	}
	//Sets the player starting position, move speed, and direction of movment and sprite
	public void setDefaultValues() {
		x = 450;
		y = 200;
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
			upAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/12.png"));
			upAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/13.png"));
			upAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/14.png"));
			down1 = ImageIO.read(new File("Sprites/HazmatGuy/11.png"));
			down2 = ImageIO.read(new File("Sprites/HazmatGuy/12.png"));
			down3 = ImageIO.read(new File("Sprites/HazmatGuy/13.png"));
			downAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/22.png"));
			downAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/23.png"));
			downAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/24.png"));
			right1 = ImageIO.read(new File("Sprites/HazmatGuy/31.png"));
			right2 = ImageIO.read(new File("Sprites/HazmatGuy/32.png"));
			right3 = ImageIO.read(new File("Sprites/HazmatGuy/33.png"));
			rightAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/32.png"));
			rightAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/33.png"));
			rightAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/34.png"));
			left1 = ImageIO.read(new File("Sprites/HazmatGuy/41.png"));
			left2 = ImageIO.read(new File("Sprites/HazmatGuy/42.png"));
			left3 = ImageIO.read(new File("Sprites/HazmatGuy/43.png"));
			leftAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/42.png"));
			leftAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/43.png"));
			leftAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/44.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// checks which keys are being pressed if any based off the key handler class and sets the sprite's corresponding direction
	// then cycles through each sprite( 2 for each direction) every 12 frames to create the running animaiton
	public void update() {
		if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed ||
			mouseH.button1 || mouseH.button2 || mouseH.button3 || mouseH.button4 || mouseH.button5) {
			keyPressed = true;
			if((keyH.upPressed && keyH.downPressed) || (keyH.rightPressed && keyH.leftPressed)) {
			} else if(keyH.upPressed && keyH.leftPressed) {
				direction = "left";
				y -= (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.upPressed && keyH.rightPressed) {
				direction = "right";
				y -= (int) Math.round(((double)speed / 1.4142));
				x += (int) Math.round(((double)speed / 1.4142));
			} else if(keyH.downPressed && keyH.leftPressed) {
				direction = "left";
				y += (int) Math.round(((double)speed / 1.4142));
				x -= (int) Math.round(((double)speed / 1.4142));
			}else if(keyH.downPressed && keyH.rightPressed) {
				direction = "right";
				y += (int) Math.round(((double)speed / 1.4142));
				x += (int) Math.round(((double)speed / 1.4142));
			}else if(keyH.upPressed) {
				direction = "up";
				y -= speed;
			}else if (keyH.downPressed) {
				direction = "down";
				y += speed;
			}else if (keyH.leftPressed) {
				direction = "left";
				x -= speed;
			}else if (keyH.rightPressed) {
				direction = "right";
				x += speed;
			}

			if (mouseH.button1) {
				isAttack = true;
			} else if (mouseH.button4) {
				System.out.println("yippee");
			}

			//Boundary wall
			if (x >= Constants.MAX_X-250) {
				x = Constants.MAX_X-250;
			} else if (x <= 60) {
				x = 60;
			}
			if (y >= Constants.MAX_Y-130-192) {
				y = Constants.MAX_Y-130-192;
			} else if (y <= 180-192) {//wall size minus player
				y = 180-192;
			}
			

			
			spriteCounter++;
			if(spriteCounter > 16) {
				sound.setSound(spriteCounter%2);
				sound.play();
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			spriteCounterMovement3++;
			if(spriteCounterMovement3 > 64) {
				spriteCounterMovement3 = 0;
			}
			if (spriteCounterAttack3 > 48) {
				spriteCounterAttack3 = 0;
			}
		}else{
			keyPressed = false;
			isAttack = false;
		}
		if(!breathSound.isPlaying()){
			breathSound.setSound(keyPressed ? 8 : 9);
			breathSound.play();
		}

		System.out.println(breathSound.isPlaying());
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
				if(spriteCounterMovement3<=16){
				image = left2;
				}if(spriteCounterMovement3>16&&spriteCounterMovement3<=32) {
				image = left1;
				}if(spriteCounterMovement3>32&&spriteCounterMovement3<=48) {
				image = left3;
				}if(spriteCounterMovement3>48&&spriteCounterMovement3<=64) {
				image = left1;
			}
			}else{
				image = left1;
			}
			break;
		case "right":
			if(keyPressed){
				if(spriteCounterMovement3<=16){
				image = right2;
				}if(spriteCounterMovement3>16&&spriteCounterMovement3<=32) {
				image = right1;
				}if(spriteCounterMovement3>32&&spriteCounterMovement3<=48) {
				image = right3;
				}if(spriteCounterMovement3>48&&spriteCounterMovement3<=64) {
				image = right1;
			}
			}else{
				image = right1;
			}
			if (isAttack) {
				if (spriteCounterAttack3 <= 16) {
					image = rightAtk1;
				} if (spriteCounterAttack3 > 16 && spriteCounterAttack3 <= 32) {
					image = rightAtk2;
				} if (spriteCounterAttack3 > 32 && spriteCounterAttack3 <= 48) {
					image = rightAtk3;
				}
			}
			break;
		}
		g2.drawImage(image, x, y, 4*gp.tileSize, 4*gp.tileSize, null);

	}

	public void setXAndY (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
