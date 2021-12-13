package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Menu{

    private final Font ButtonFont = new Font("Helvetica", Font.BOLD, 30);
    private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, GamePanel.WIDTH, GamePanel.HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(TitleFont);
        g.drawString("AIM BOT", GamePanel.WIDTH/2 - 100, 150);

        makeButton("PLAY", GamePanel.WIDTH/2 - 75, 225, 150, 50, g);
        makeButton(" EXIT", GamePanel.WIDTH/2 - 75, 325, 150, 50, g);
	}

    private void makeButton(String button, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.setFont(ButtonFont);
        g.drawString(button, x+35, y+35);
    }


    public boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if((mouseX > x && mouseX < x + width) && (mouseY > y && mouseY < y + height)){
            return true;
        }else{
            return false;
        }
    }
    
}
