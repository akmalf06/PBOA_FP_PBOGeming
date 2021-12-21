package fppbo.huntgame.Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Button {
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;
    private Font f;
    
    
    public Button (String text, int x, int y, int width, int height, Font f) {
    	this.text = text;
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.f = f; 
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        FontMetrics metrics = g.getFontMetrics(f);
        int x = this.x + (this.width - metrics.stringWidth(text)) / 2;
        int y = this.y + ((this.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(f);
        g.drawString(text, x, y);
    }
    
    public boolean mouseOver(int mouseX, int mouseY){
        if((mouseX > x && mouseX < x + width) && (mouseY > y && mouseY < y + height)){
            return true;
        }else{
            return false;
        }
    }
}
