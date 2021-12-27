package fppbo.huntgame.Components;

import java.awt.Graphics;

import fppbo.huntgame.Services.ImageLoader;

public class TargetArea {
    private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private ImageLoader targetArea;

	public TargetArea(int x, int y, int width, int height) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + width - 1;
		this.maxY = y + height - 1;

		targetArea = new ImageLoader("targetArea.png");
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
		targetArea.draw(g, minX, minY,  maxX - minX - 1, maxY - minY - 1);
	}
}
