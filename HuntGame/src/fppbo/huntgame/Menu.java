package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Menu{

    private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, GamePanel.WIDTH, GamePanel.HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(TitleFont);
        g.drawString("AIM BOT", GamePanel.WIDTH/2 - 100, 150);

        Button.makeButton("PLAY", GamePanel.WIDTH/2 - 75, 225, 150, 50, g);
        Button.makeButton(" EXIT", GamePanel.WIDTH/2 - 75, 325, 150, 50, g);
	}

    public boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if((mouseX > x && mouseX < x + width) && (mouseY > y && mouseY < y + height)){
            return true;
        }else{
            return false;
        }
    }
    
}
