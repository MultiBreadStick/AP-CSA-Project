package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    //checks which WASD keys are being pressed
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = true;
			
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;

		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;

		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;

		}
		
		
		
	}

    //checks which WASD keys are released
    //we might not need this but it was easy to copy and paste
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
			
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;

		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;

		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;

		}
	}
	
}
