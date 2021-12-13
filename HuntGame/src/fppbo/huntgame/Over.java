package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Over {
	private Score score;
	private static final Font ButtonFont = new Font("Helvetica", Font.BOLD, 30);
	private final Font TitleFont = new Font("Helvetica", Font.BOLD, 50);
	
	public Over(Score score) {
		this.score = score;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
        g.drawRect(GamePanel.WIDTH/2 - 200, GamePanel.HEIGHT/2 - 100, 400, 200);
        g.setFont(TitleFont);
        g.drawString("GAME OVER", GamePanel.WIDTH/2 - 150, GamePanel.HEIGHT/2 - 20);
        g.setFont(ButtonFont);
        g.drawString("Your Score: " + score.getScore(), GamePanel.WIDTH/2 - 100, GamePanel.HEIGHT/2 + 40);
	}
}
