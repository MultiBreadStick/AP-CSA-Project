package mainObjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 * The Map class represents the game map consisting of rooms and their images.
 */
public class Map {
    // Instance variables
    public Room[][] map;
    private int stageLevel;
    public BufferedImage botLeft, botRight, topLeft, topRight, bot, top, right, left, middle, image;
    GamePanel gp;

    /**
     * Constructs a Map with the specified level and game panel.
     *
     * @param level the level of the map
     * @param gp the game panel associated with the map
     */
    public Map(int level, GamePanel gp) {
        getMapImage();
        this.stageLevel = level;
        this.gp = gp;
        image = botLeft;
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
                if (map[i][j].getInRoom() && j != 4) {
                    map[i][j + 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                    return;
                }
            }
        }
    }
    public void nextRoomLeft() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && j != 0) {
                    map[i][j - 1].setInRoom(true);
                    map[i][j].setInRoom(false);
                    return;
                }
            }
        }
    }
    public void nextRoomUp() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 4) {
                    map[i + 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                    return;
                }
            }
        }
    }
    public void nextRoomDown() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom() && i != 0) {
                    map[i - 1][j].setInRoom(true);
                    map[i][j].setInRoom(false);
                    return;
                }
            }
        }
    }

    public BufferedImage getRoomImage() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].getInRoom()) {
                    if (j == 0 && i == 0) {
                        image = botLeft;
                    } else if (j == 0 && i == 4) {
                        image = topLeft;
                    } else if (j == 4 && i == 0) {
                        image = botRight;
                    } else if (j == 4 && i == 4) {
                        image = topRight;
                    } else if (j == 0) {
                        image = left;
                    } else if (j == 4) {
                        image = right;
                    } else if (i == 0) {
                        image = top;
                    } else if (i == 4) {
                        image = bot;
                    } else image = middle;
                }
            }
        }
        return image;
    }

    /**
     * Loads the map images.
     */
    private void getMapImage() {
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
        image = getRoomImage();
        g2.drawImage(image, 0, 0, Constants.MAX_X, Constants.MAX_Y, null);
    } 
}
