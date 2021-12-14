package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Button {
	private static final Font big = new Font("Helvetica", Font.BOLD, 30);
    private static final Font small = new Font("Helvetica", Font.BOLD,15);

	public static void bigButton(String button, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.setFont(big);
        g.drawString(button, x+35, y+35);
    }

    public static void smallButton(String button, int x, int y, int width, int height, Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.setFont(small);
        g.drawString(button, x+32, y+25);
    }
    
}
