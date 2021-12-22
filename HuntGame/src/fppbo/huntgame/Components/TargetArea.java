package fppbo.huntgame.Components;

import java.awt.Color;
import java.awt.Graphics;

public class TargetArea {
    private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private Color colorFilled;
	private Color colorBorder;

	public TargetArea(int x, int y, int width, int height, Color colorFilled, Color colorBorder) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + width - 1;
		this.maxY = y + height - 1;
		this.colorFilled = colorFilled;
		this.colorBorder = colorBorder;
	}

	public int getMinX() {
		return minX;
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMinY() {
		return minY;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public void set(int x, int y, int width, int height) {
		minX = x;
		minY = y;
		maxX = x + width - 1;
		maxY = y + height - 1;
	}

	public void draw(Graphics g) {
		g.setColor(colorFilled);
		g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
		g.setColor(colorBorder);
		g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
	}
}
