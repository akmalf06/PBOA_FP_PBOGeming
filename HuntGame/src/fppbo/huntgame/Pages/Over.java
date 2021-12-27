package fppbo.huntgame.Pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import fppbo.huntgame.GamePanel;
import fppbo.huntgame.Components.Button;
import fppbo.huntgame.Components.Player;

public class Over {
	private Player player;
	private Button playAgainButton;
	private Button menuButton;

	public Over(Player player) {
		this.player = player;
		playAgainButton = new Button("PLAY AGAIN", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 30, 150, 40, new Font("Helvetica", Font.BOLD, 15));
        menuButton = new Button("MENU", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 80, 150, 40, new Font("Helvetica", Font.BOLD, 15));
	}
	
	public Button getPlayAgainButton() {
		return playAgainButton;
	}

	public Button getMenuButton() {
		return menuButton;
	}

	public void draw(Graphics g) {
		g.setColor(new Color(9, 21, 66));
        g.fillRect(GamePanel.WIDTH/2 - 200, GamePanel.HEIGHT/2 - 140, 400, 290);

		g.setColor(new Color(67, 221, 226));
        g.drawRect(GamePanel.WIDTH/2 - 200, GamePanel.HEIGHT/2 - 140, 400, 290);

        FontMetrics metrics = g.getFontMetrics(new Font("Helvetica", Font.BOLD, 30));
        int x = GamePanel.WIDTH/2 - 200 + (400 - metrics.stringWidth("GAME OVER")) / 2;
        g.setFont(new Font("Helvetica", Font.BOLD, 30));
        g.drawString("GAME OVER", x, GamePanel.HEIGHT/2 - 60);
        x = GamePanel.WIDTH/2 - 200 + (400 - metrics.stringWidth("Your Score: " + player.getScoreValue())) / 2;
        g.drawString("Your Score: " + player.getScoreValue(), GamePanel.WIDTH/2 - 100, GamePanel.HEIGHT/2);
        
        playAgainButton.draw(g);
        menuButton.draw(g);
	}
}
