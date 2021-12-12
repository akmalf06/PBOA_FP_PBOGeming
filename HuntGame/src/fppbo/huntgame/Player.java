package fppbo.huntgame;

import java.awt.*;

public class Player {
	private String name;
	private Score score;
	private int width;
	private int height;
	private int ammo;
	private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

	public Player(String name, Score score, int width, int height) {
		this.name = name;
		this.score = score;
		this.ammo = 5;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
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

    public void draw(Graphics g) {
		String s;

        g.setFont(smallFont);
        g.setColor(new Color(96, 128, 255));
        s = "Ammo: " + this.ammo;
        g.drawString(s, 30, this.height-10);
	}
}
