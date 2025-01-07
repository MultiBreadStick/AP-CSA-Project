package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import mainObjects.Map;

public class Speaker{
	
	GamePanel gp;
	KeyHandler keyH;
	public Map map;
	public String talker;
    BufferedImage kenCurie;
	
	public Speaker(GamePanel gp) {
		this.gp = gp;
		this.map = gp.map;
		getSpeakerImage();
	}

	public void getSpeakerImage() {
		try {
			kenCurie = ImageIO.read(new File("Sprites/kenCurie.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		talker = "kenCurie";
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(talker) {
		case "kenCurie":
			image = kenCurie;
			break;
        }
		g2.drawImage(image, 190, 500, 8*gp.tileSize, 12*gp.tileSize, null);

	}

}
