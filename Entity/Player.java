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
	sounds attackSounds = new sounds();
	private BufferedImage image = null;
	
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
			upAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK22.png"));
			upAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK23.png"));
			upAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK24.png"));
			down1 = ImageIO.read(new File("Sprites/HazmatGuy/11.png"));
			down2 = ImageIO.read(new File("Sprites/HazmatGuy/12.png"));
			down3 = ImageIO.read(new File("Sprites/HazmatGuy/13.png"));
			downAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK12.png"));
			downAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK13.png"));
			downAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK14.png"));
			right1 = ImageIO.read(new File("Sprites/HazmatGuy/31.png"));
			right2 = ImageIO.read(new File("Sprites/HazmatGuy/32.png"));
			right3 = ImageIO.read(new File("Sprites/HazmatGuy/33.png"));
			rightAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK32.png"));
			rightAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK33.png"));
			rightAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK34.png"));
			left1 = ImageIO.read(new File("Sprites/HazmatGuy/41.png"));
			left2 = ImageIO.read(new File("Sprites/HazmatGuy/42.png"));
			left3 = ImageIO.read(new File("Sprites/HazmatGuy/43.png"));
			leftAtk1 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK42.png"));
			leftAtk2 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK43.png"));
			leftAtk3 = ImageIO.read(new File("Sprites/HazmatGuy/ATK/ATK44.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// checks which keys are being pressed if any based off the key handler class and sets the sprite's corresponding direction
	// then cycles through each sprite( 2 for each direction) every 12 frames to create the running animaiton
	public void update() {
		updateMovement();
		checkBoundaryWall();
		updateMoveSprites(); 
		updateAttack();
		updateAttackSprites();
		updateSound();
	}
	// this sets which image the player sprite is supposed to be using a switch statment based off our update() method
	// then it actually draws the player onto the screen in whatever location its supposed to be in
	public void draw(Graphics2D g2) {
		drawMovement();
		drawAttack();

		g2.drawImage(image, x, y, 4*gp.tileSize, 4*gp.tileSize, null);

	}

	private void updateMovement () {
		if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
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
		}

	}

	private void checkBoundaryWall() {
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
	}

	private void updateMoveSprites() {
		if (keyPressed) {
			spriteCounter++;
		if(spriteCounter > 16) {
			sound.setSound(8);
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
		}
	}

	private void updateAttack() {
		if (mouseH.button1 || mouseH.button2 ) {
			if (mouseH.button1) {
				isAttack = true;
				if (spriteCounterAttack3 == 0) {
					spriteCounterAttack3 = 1;
				}
			}
		} else {
			if(isAttack) {
				spriteCounterAttack3++;
			} else {
				spriteCounterAttack3 = 0;
			}
		}
	}

	private void updateAttackSprites() {
		if (mouseH.button1 || mouseH.button2 ) {
			if (mouseH.button1) {
				isAttack = true;
				if (spriteCounterAttack3 == 0) {
					spriteCounterAttack3 = 1;
				}
			}
		} else {
			if(isAttack) {
				spriteCounterAttack3++;
			}
		}
	}

	private void updateSound() {
		if(!sound.isPlaying()) {
			sound.muted = true;
			sound.setSound(4);
		}

		if(!breathSound.isPlaying()){
			breathSound.muted = true;
			breathSound.setSound(keyPressed ? 8 : 9);
			breathSound.play();
		}

		if(isAttack && !attackSounds.isPlaying()) {
			attackSounds.setSound(11);
		}
	}




	private void drawMovement() {
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
				break;
			}
	}

	private void drawAttack() {
		switch(direction) {
			case "up" :
				if (isAttack && !(spriteCounterAttack3 == 0)) {
					if (spriteCounterAttack3 <= 4) {
						image = upAtk1;
					} else if (spriteCounterAttack3 > 4 && spriteCounterAttack3 <= 16) {
						image = upAtk2;
					} else if (spriteCounterAttack3 > 16 && spriteCounterAttack3 < 20) {
						image = upAtk3;
					} else if (spriteCounterAttack3 > 20) {
						spriteCounterAttack3 = 0;
						isAttack = false;
					}
					spriteCounterAttack3++;
				}
			break;

			case "down" :
				if (isAttack && !(spriteCounterAttack3 == 0)) {
					if (spriteCounterAttack3 <= 4) {
						image = downAtk1;
					} else if (spriteCounterAttack3 > 4 && spriteCounterAttack3 <= 16) {
						image = downAtk2;
					} else if (spriteCounterAttack3 > 16 && spriteCounterAttack3 < 20) {
						image = downAtk3;
					} else if (spriteCounterAttack3 > 20) {
						image = down1;
						spriteCounterAttack3 = 0;
						isAttack = false;
					}
					spriteCounterAttack3++;
				}
			break;

			case "left" :
				if (isAttack && !(spriteCounterAttack3 == 0)) {
					if (spriteCounterAttack3 <= 4) {
						image = leftAtk1;
					} else if (spriteCounterAttack3 > 4 && spriteCounterAttack3 <= 16) {
						image = leftAtk2;
					} else if (spriteCounterAttack3 > 16 && spriteCounterAttack3 < 20) {
						image = leftAtk3;
					} else if (spriteCounterAttack3 > 20) {
						image = left1;
						spriteCounterAttack3 = 0;
						isAttack = false;
					}
					spriteCounterAttack3++;
				}
			break;

			case "right" :
				if (isAttack && !(spriteCounterAttack3 == 0)) {
					if (spriteCounterAttack3 <= 4) {
						image = rightAtk1;
					} else if (spriteCounterAttack3 > 4 && spriteCounterAttack3 <= 16) {
						image = rightAtk2;
					} else if (spriteCounterAttack3 > 16 && spriteCounterAttack3 < 20) {
						image = rightAtk3;
					} else if (spriteCounterAttack3 > 20) {
						image = right1;
						spriteCounterAttack3 = 0;
						isAttack = false;
					}
					spriteCounterAttack3++;
				}
			break;
		}
	}
}