package fppbo.huntgame.Components;

import java.awt.*;

import fppbo.huntgame.GamePanel;

public class Score {
    
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

    private int score;

    public Score(){
        this.score = 0;
    }
    
    public int getScore() {
    	return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void draw(Graphics g) {
		String s;

        g.setFont(smallFont);
        g.setColor(new Color(96, 128, 255));
        s = "Score: " + score;
        g.drawString(s, GamePanel.WIDTH-100, GamePanel.HEIGHT-10);
	}
    
}
