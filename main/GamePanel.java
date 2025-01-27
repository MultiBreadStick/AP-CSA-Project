package main;

import Entity.EnemyAI;
import Entity.Player;
import Entity.Speaker;
import Entity.blackFade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import mainObjects.Map;

public class GamePanel extends JPanel implements Runnable{
	
	//Statics for the game window size and FPS
	final int ogTileSize= 16;
	final int scale = 3;
	public final int tileSize = ogTileSize * scale;
	final int maxScreenCol = 48;
	final int maxScreenRow = 32;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	int FPS = 60;
	
	//creates the player and key listner
	KeyHandler keyH = new KeyHandler();
	MouseHandler mouseH = new MouseHandler();
	Thread gameThread;
	public Map map = new Map(1, this);
	Player player = new Player(this, keyH, mouseH);
	Speaker speaker = new Speaker(this);
	public blackFade BlackFade = new blackFade();
	sounds sound = new sounds();

	
	//window constructor based off our variables
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground( new Color(1, 1, 1));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.setFocusable(true);
	}

	//this starts the game loop
	public void startGameThread() {
	
		gameThread = new Thread(this);
		gameThread.start();
	}

	// this is the run op
	@Override
	public void run() {
		map.spawnEnemies(1);
		//sound.setSound(4);
		//sound.play();
		//sound.loop();
		double drawInterval = 1000000000/FPS; 
		double nextDrawTime = System.nanoTime() + drawInterval;
		// this is te game loop
		while(gameThread != null ) {
			//this creates the frame and updates the game
			update();
			//redraws everything on the window
			repaint();
			
			
			// this is the wait
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				// this  is just to remsiningTime doesn't become negative and resets to 0
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update() {
		speaker.update();
		player.update(); // updates the player state as this is the only thing we have right now, see player class for more
		BlackFade.update();
		List<EnemyAI> enemiesToRemove = new ArrayList<>();

    // First loop to check and mark dead enemies
    for(EnemyAI enemy : map.enemies) {
        if(enemy.thisEnemy.isDead) {
            enemiesToRemove.add(enemy); // Add the dead enemy to the removal list
        }
    }

    // Now remove enemies outside of the iteration loop
    for (EnemyAI enemy : enemiesToRemove) {
        map.removeEnemy(enemy); // Remove the enemy from the map
    }

    // Second loop to update the remaining enemies
    for(EnemyAI enemy : map.enemies) {
        enemy.enemyMovement(player); // Move the remaining enemies
    }
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clears the screen
		Graphics2D g2 = (Graphics2D)g; // casts to Graphics2D
		map.draw(g2);
		player.draw(g2); // draws the player
		speaker.draw(g2);
		BlackFade.draw(g2);
		g2.dispose(); // clears the graphics2D resources
		// see the player class for more
	}
	

}
