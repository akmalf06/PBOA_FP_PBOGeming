package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Menu{

    private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(TitleFont);
        g.drawString("AIM BOT", GamePanel.WIDTH/2 - 100, 150);
        
        Button button1 = new Button("PLAY", GamePanel.WIDTH/2 - 75, 225, 150, 50, new Font("Helvetica", Font.BOLD, 30));
        Button button2 = new Button("EXIT", GamePanel.WIDTH/2 - 75, 325, 150, 50, new Font("Helvetica", Font.BOLD, 30));
        
        button1.draw(g);
        button2.draw(g);
	}    
}
