package fppbo.huntgame;

import java.awt.*;

public class Score {
    
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

    private int score;
    private int width;
    private int height;

    public Score(int score, int width, int heigth){
        this.score = score;
        this.width = width;
        this.height = heigth;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void draw(Graphics g) {
		String s;

        g.setFont(smallFont);
        g.setColor(new Color(96, 128, 255));
        s = "Score: " + score;
        g.drawString(s, this.width-100, this.height-10);
	}
    
}
