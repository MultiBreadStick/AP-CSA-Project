package entity; //sigma sigma on the wall im the skividiest of them all 

import java.awt.image.BufferedImage;
// general class that has the basic veriables needed for an entity
public class Entity {
	
	public int x, y;
	public int speed;
	
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;

}
