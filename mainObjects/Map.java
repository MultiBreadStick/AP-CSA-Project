package mainObjects;

import Entity.EnemyAI;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;
//import mainObjects.Object;


public class Map {
    //public Object[][] objArray;
    public List<EnemyAI> enemies = new ArrayList<>();
    private int stageLevel;
    public BufferedImage botLeft, botRight, topLeft, topRight, bot, top, right, left, middle, image;
    GamePanel gp;

    
    public Map(int level, GamePanel gp) {
        getMapImage();
        this.stageLevel = level;
        //switch case based on stage level goes here in the future
        this.gp = gp;
    }
    //spawn enemies
    public void spawnEnemies(int enemyNum){
        Random random = new Random();
        for( int i = 0; i < enemyNum; i++){
            EnemyAI newEnemy = new EnemyAI(random.nextInt(1670 - 60 + 1) + 60, random.nextInt(760 - (-10) + 1) - 10, Constants.crab, gp);
            enemies.add(newEnemy);
        }
    }
    //delete ememies
    public void removeEnemy(EnemyAI enemy){
        enemies.remove(enemy);
    }

    //Bare bones so we can import new images easily and set up better stuff
    public BufferedImage getRoomImage() {
        switch (stageLevel) {
            case 0:
                return botLeft;
            case 1:
                return bot;
            case 2:
                return botRight;
            case 3:
                return left;
            case 4:
                return middle;
            case 5:
                return right;
            case 6:
                return topLeft;
            case 7:
                return top;
            case 8:
                return topRight;
            default:
                return null;
        }
    }

    
    private void getMapImage() {
        try {
            botLeft = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            botRight = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            topLeft = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            topRight = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            left = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            right = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            top = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            bot = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
            middle = ImageIO.read(new File("Sprites/GrassRoom/41.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = getRoomImage();
        g2.drawImage(image, 0, 0, Constants.MAX_X, Constants.MAX_Y, null);
        for (EnemyAI enemy : enemies) {
            enemy.draw(g2);
        }
    } 
}
