package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Button {
	private static final Font ButtonFont = new Font("Helvetica", Font.BOLD, 30);
	public static void makeButton(String button, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.setFont(ButtonFont);
        g.drawString(button, x+35, y+35);
    }
}
