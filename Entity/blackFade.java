package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class blackFade {
    private int opacity;
    public boolean visible;
    private boolean fadingIn;

    public blackFade(){
        this.opacity = 0;
        this.visible = false;
        this.fadingIn = true;
    }
    public void update(){
        if(!visible){
            return;
        }
        if (fadingIn) {
            opacity += 51;
            if (opacity >= 255) {
                opacity = 255;
                fadingIn = false;
            }
        } else {
            opacity -= 3;
            if (opacity <= 0) {
                opacity = 0;
                fadingIn = true;
                visible = false;
            }
        }
        
    }
    public void draw(Graphics2D g2){
        if(!visible){
            return;
        }
        g2.setColor(new Color(0, 0, 0, opacity));
        g2.fillRect(0, 0, 2304, 3072);
    }
}
