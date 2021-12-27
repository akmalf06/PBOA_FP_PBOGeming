package fppbo.huntgame.Pages;

import java.awt.Font;
import java.awt.Graphics;

import fppbo.huntgame.GamePanel;
import fppbo.huntgame.Components.Background;
import fppbo.huntgame.Components.Button;
import fppbo.huntgame.Services.ImageLoader;


public class Menu{

    private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);
    private Button playButton;
    private Button exitButton;
    private Background bg;
    private ImageLoader gameTittle;
    
    public Menu() {
        playButton = new Button("PLAY", GamePanel.WIDTH/2 - 85, 275, 170, 50, new Font("Helvetica", Font.BOLD, 30));
        exitButton = new Button("EXIT", GamePanel.WIDTH/2 - 85, 345, 170, 50, new Font("Helvetica", Font.BOLD, 30));
        bg = new Background();
        gameTittle = new ImageLoader("gameTittle.png");
    }

    public void draw(Graphics g){
        bg.draw(g);
        gameTittle.draw(g, 75, 100, 350, 100);
        
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
