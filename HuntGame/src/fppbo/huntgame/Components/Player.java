package fppbo.huntgame.Components;

import java.awt.*;

import fppbo.huntgame.GamePanel;

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
        if(target.getTargetType() == "bomb"){
        	this.getScore().setScore(this.getScoreValue()-5);
        }else if(target.getTargetType() == "chicken"){
        	this.getScore().setScore(this.getScoreValue()+1);
		}else if(target.getTargetType() == "sheep"){
        	this.getScore().setScore(this.getScoreValue()+2);
		}else if(target.getTargetType() == "pig"){
        	this.getScore().setScore(this.getScoreValue()+3);
		}else if(target.getTargetType() == "bear"){
        	this.getScore().setScore(this.getScoreValue()+4);
		}
    }

    public void draw(Graphics g) {
		String s;
        g.setFont(smallFont);
        g.setColor(new Color(67, 221, 226));
        s = "Ammo: " + this.ammo;
        g.drawString(s, 30, GamePanel.HEIGHT-25);
        score.draw(g);
	}
}
