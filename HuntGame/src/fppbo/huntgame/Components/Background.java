package fppbo.huntgame.Components;

import java.awt.Graphics;

import fppbo.huntgame.Services.ImageLoader;

public class Background {
    private ImageLoader bg;

    public Background(){
        bg = new ImageLoader("background.png");
    }
    
    public void draw(Graphics g) {
		bg.draw(g, 0, 0, 500, 500);
	}
}
