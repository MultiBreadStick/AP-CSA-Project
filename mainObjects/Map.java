package mainObjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Map {
    //Instance variables
    private Room[][] map;
    private int stageLevel;
    public BufferedImage botLeft, botRight, topLeft, topRight, bot, top, right, left, middle;

	GamePanel gp;

    
    //Constructor
    public Map(int level, GamePanel gp) {
	getMapImage();
        this.stageLevel = level;
	    map = new Room[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int roomGen = (int)(Math.random() * 10);
                if (roomGen == 9) {
                    map[i][j] = new Room(stageLevel, false, "treasure", 0);
                } else {
                    map[i][j] = new Room(stageLevel, false, "Crab", (int)(Math.random() * 3 + 1));
                }
            }
        }
        map[0][0] = new Room(stageLevel, true, "empty", 0);
    }

    //move room
    public void nextRoomRight() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 4) {
                    map[i + 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomLeft() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 0) {
                    map[i - 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomUp() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && j != 4) {
                    map[i][j + 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }
    public void nextRoomDown() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && j != 0) {
                    map[i][j - 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                }
            }
        }
    }

    public void getMapImage() {
		try {
			botLeft = ImageIO.read(new File("Sprites/GrassRoom/25.png"));
			botRight = ImageIO.read(new File("Sprites/GrassRoom/26.png"));
			topLeft = ImageIO.read(new File("Sprites/GrassRoom/23.png"));
			topRight = ImageIO.read(new File("Sprites/GrassRoom/22.png"));
			left = ImageIO.read(new File("Sprites/GrassRoom/34.png"));
			right = ImageIO.read(new File("Sprites/GrassRoom/33.png"));
			top = ImageIO.read(new File("Sprites/GrassRoom/32.png"));
			bot = ImageIO.read(new File("Sprites/GrassRoom/31.png"));
            middle = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
        image = middle;
		g2.drawImage(image, 0, 0, Constants.MAX_X, Constants.MAX_Y, null);
    } 
} 
