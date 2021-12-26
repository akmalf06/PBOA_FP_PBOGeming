package fppbo.huntgame.Services;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageLoader {
    private BufferedImage img;

    public ImageLoader(String fileName) {
		this.setImage(fileName);
	}

    public void setImage(String fileName) {
		try {
			img = ImageIO.read(new File("resources/Image/"+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void draw(Graphics g, int x, int y, int width, int height){
        g.drawImage(img, x, y, width, height, null);
    }
    
}
