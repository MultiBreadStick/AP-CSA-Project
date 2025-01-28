package main;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends Frame implements MouseListener {

    public boolean button1, button2, button3, button4, button5;

    @Override
    public void mouseClicked(MouseEvent e) {
        int code = e.getButton();
        if(code == MouseEvent.BUTTON1) {
			button1 = true;
		}
		if(code == MouseEvent.BUTTON2) {
			button2 = true;
		}
		if(code == MouseEvent.BUTTON3) {
			button3 = true;
		}
        if(code == 4) {
            button4 = true;
        }
        if(code == 5) {
            button5 = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}