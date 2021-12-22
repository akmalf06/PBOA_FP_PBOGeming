package fppbo.huntgame.Pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import fppbo.huntgame.GamePanel;
import fppbo.huntgame.Components.Button;

public class Tutorial {
	private final Font titleFont = new Font("Helvetica", Font.BOLD, 42);
	private final Font textFont = new Font("Helvetica", Font.PLAIN, 16);
	private Button nextButton;
	
	public Tutorial() {
		this.nextButton = new Button("NEXT", 175, 380, 150, 50, new Font("Helvetica", Font.BOLD, 30));
	}
	
	public Button getNextButton() {
		return nextButton;
	}
 
	public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("HOW TO PLAY", 114, 74);
		g.setFont(textFont);
		g.drawString("1.", 139, 124);
		g.drawString("Bola hijau akan menambahkan", 160, 124);
		g.drawString("point jika berhasil di-klik dengan", 160, 142);
		g.drawString("klik kiri", 160, 160);
		g.drawString("2.", 139, 189);
		g.drawString("Bola merah akan mengurangi", 160, 189);
		g.drawString("point jika berhasil di-klik dengan", 160, 207);
		g.drawString("klik kiri", 160, 225);
		g.drawString("3.", 139, 254);
		g.drawString("Klik kanan akan menetralkan bola", 160, 254);
		g.drawString("4.", 139, 283);
		g.drawString("Setiap klik kanan dan kiri akan", 160, 283);
		g.drawString("menggunakan satu ammo", 160, 301);
		g.drawString("5.", 139, 330);
		g.drawString("Tekan R untuk reload ammo", 160, 330);
		this.nextButton.draw(g);
	}
}
