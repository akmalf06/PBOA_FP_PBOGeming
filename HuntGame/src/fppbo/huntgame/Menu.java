package fppbo.huntgame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.RepaintManager;

public class Menu{

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.setColor(Color.WHITE);
        g.drawRect(GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 - 25, 150, 50);
        g.drawString("PLAY", GamePanel.WIDTH/2, GamePanel.HEIGHT/2);
        
	}

    public boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if((mouseX > x && mouseX < x + width) && (mouseY > y && mouseY < y + height)){
            return true;
        }else{
            return false;
        }
    }
    
}
