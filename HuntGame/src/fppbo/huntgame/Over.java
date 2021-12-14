package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Over {
	private Score score;
	private static final Font big = new Font("Helvetica", Font.BOLD, 30);
    private static final Font title = new Font("Helvetica", Font.BOLD,50);

	public Over(Score score) {
		this.score = score;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
        g.drawRect(GamePanel.WIDTH/2 - 200, GamePanel.HEIGHT/2 - 140, 400, 290);
        g.setFont(title);
        g.drawString("GAME OVER", GamePanel.WIDTH/2 - 150, GamePanel.HEIGHT/2 - 60);
        g.setFont(big);
        g.drawString("Your Score: " + score.getScore(), GamePanel.WIDTH/2 - 100, GamePanel.HEIGHT/2);

		Button.smallButton("PLAY AGAIN", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 30, 150, 40, g);
		Button.smallButton("     MENU", GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 80, 150, 40, g);
	}
}
