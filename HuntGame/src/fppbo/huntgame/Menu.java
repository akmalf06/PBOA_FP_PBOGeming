package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Menu{

    private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);
    private Button playButton;
    private Button exitButton;
    
    public Menu() {
        playButton = new Button("PLAY", GamePanel.WIDTH/2 - 75, 225, 150, 50, new Font("Helvetica", Font.BOLD, 30));
        exitButton = new Button("EXIT", GamePanel.WIDTH/2 - 75, 325, 150, 50, new Font("Helvetica", Font.BOLD, 30));
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        
        g.setColor(Color.WHITE);
        g.setFont(TitleFont);
        g.drawString("AIM BOT", GamePanel.WIDTH/2 - 100, 150);
        
        playButton.draw(g);
        exitButton.draw(g);
	}

	public Font getTitleFont() {
		return TitleFont;
	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button getExitButton() {
		return exitButton;
	}    
}
