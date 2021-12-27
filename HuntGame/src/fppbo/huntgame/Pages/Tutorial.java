package fppbo.huntgame.Pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import fppbo.huntgame.Components.Background;
import fppbo.huntgame.Components.Button;
import fppbo.huntgame.Services.ImageLoader;

public class Tutorial {
	private final Font titleFont = new Font("Helvetica", Font.BOLD, 42);
	private final Font textFont = new Font("Helvetica", Font.PLAIN, 16);
	private Button nextButton;
	private Background bg;
	private ImageLoader leftclick;
	private ImageLoader rightclick;
	private ImageLoader keyR;
	private ImageLoader chicken;
	private ImageLoader sheep;
	private ImageLoader pig;
	private ImageLoader bear;
	private ImageLoader bomb;
	
	public Tutorial() {
		nextButton = new Button("NEXT", 175, 400, 150, 50, new Font("Helvetica", Font.BOLD, 30));
		bg = new Background();
		leftclick = new ImageLoader("left-click.png");
		rightclick = new ImageLoader("right-click.png");
		keyR = new ImageLoader("keyR.png");
		chicken = new ImageLoader("chicken.png");
		sheep = new ImageLoader("sheep.png");
		pig = new ImageLoader("pig.png");
		bear = new ImageLoader("bear.png");
		bomb = new ImageLoader("bomb.png");
	}
	
	public Button getNextButton() {
		return nextButton;
	}
 
	public void draw(Graphics g) {
		bg.draw(g);

		g.setColor(new Color(67, 221, 226));
		g.setFont(titleFont);
		g.drawString("HOW TO PLAY", 105, 100);

		g.setFont(textFont);

		leftclick.draw(g, 102, 135, 25, 25);
		g.drawString("Klik kiri", 135, 155);
		g.drawString("= Shoot/Tembak target", 230, 155);

		rightclick.draw(g, 105, 170, 25, 25);
		g.drawString("Klik kanan", 135, 190);
		g.drawString("= Skip/Lewati target", 230, 190);

		keyR.draw(g, 107, 208, 20, 20);
		g.drawString("Klik R", 135, 225);
		g.drawString("= Reload", 230, 225);

		g.drawString("SCORE", 220, 280);
		
		chicken.draw(g, 100, 300, 50, 50);
		sheep.draw(g, 160, 300, 50, 50);
		pig.draw(g, 220, 300, 50, 50);
		bear.draw(g, 280, 300, 50, 50);
		bomb.draw(g, 340, 300, 50, 50);

		g.setColor(Color.green);
		g.drawString("+1", 115, 370);
		g.drawString("+2", 175, 370);
		g.drawString("+3", 235, 370);
		g.drawString("+4", 295, 370);
		g.setColor(Color.red);
		g.drawString("-5", 355, 370);

		this.nextButton.draw(g);
	}
}
