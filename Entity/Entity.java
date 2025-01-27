package Entity; //sigma sigma on the wall im the skividiest of them all 

import java.awt.image.BufferedImage;
// general class that has the basic veriables needed for an entity
public class Entity {
	
	public int x, y;
	public int speed;
	
	public BufferedImage up1, up2, up3, upAtk1, upAtk2, upAtk3; 
	public BufferedImage down1, down2, down3, downAtk1, downAtk2, downAtk3;
	public BufferedImage left1, left2, left3, leftAtk1, leftAtk2, leftAtk3;
	public BufferedImage right1, right2, right3, rightAtk1, rightAtk2, rightAtk3;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	

}
