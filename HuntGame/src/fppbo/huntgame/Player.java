package fppbo.huntgame;

import java.awt.*;

public class Player {
	private Score score;
	private int ammo;
	private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

	public Player() {
		this.score = new Score();
		this.ammo = 5;
	}

	public Score getScore() {
		return score;
	}
	
	public int getScoreValue() {
		return this.getScore().getScore();
	}

	public int getAmmo() {
		return ammo;
	}
	
	public void useAmmo() {
		if(ammo > 0) {
			ammo -= 1;
		}
	}
	
	public void reloadAmmo() {
		ammo = 5;
	}
	
	public void updateScore(Target target){
        if(target.getColor() == Color.GREEN){
        	this.getScore().setScore(this.getScoreValue()+1);
        }else{
        	this.getScore().setScore(this.getScoreValue()-1);
        }
    }

    public void draw(Graphics g) {
		String s;
        g.setFont(smallFont);
        g.setColor(new Color(96, 128, 255));
        s = "Ammo: " + this.ammo;
        g.drawString(s, 30, GamePanel.HEIGHT-10);
        score.draw(g);
	}
}
