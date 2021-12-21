package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Over {
	private Score score;
	private Button playAgainButton;
	private Button menuButton;

	public Over(Score score) {
		this.score = score;
		playAgainButton = new Button("PLAY AGAIN", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 30, 150, 40, new Font("Helvetica", Font.BOLD, 30));
        menuButton = new Button("MENU", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 80, 150, 40, new Font("Helvetica", Font.BOLD, 30));
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
        g.drawRect(GamePanel.WIDTH/2 - 200, GamePanel.HEIGHT/2 - 140, 400, 290);
        g.setFont(new Font("Helvetica", Font.BOLD, 30));
        g.drawString("GAME OVER", GamePanel.WIDTH/2 - 150, GamePanel.HEIGHT/2 - 60);
        g.setFont(new Font("Helvetica", Font.BOLD, 30));
        g.drawString("Your Score: " + score.getScore(), GamePanel.WIDTH/2 - 100, GamePanel.HEIGHT/2);
        
        playAgainButton.draw(g);
        menuButton.draw(g);
	}
}
