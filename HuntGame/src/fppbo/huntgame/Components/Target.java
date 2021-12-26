package fppbo.huntgame.Components;

import java.awt.Graphics;
import java.util.Random;

import fppbo.huntgame.Services.ImageLoader;

public class Target {
    private float x, y;
	private float speedX, speedY;
	private float radius;
	private ImageLoader target;
	private String targetType;

	public Target(float x, float y, float radius, float speed, float angleInDegree, String targetType) {
		this.x = x;
		this.y = y;
		this.speedX = (float) (speed * Math.cos(Math.toRadians(angleInDegree)));
		this.speedY = (float) (-speed * (float) Math.sin(Math.toRadians(angleInDegree)));
		this.radius = radius;
		this.targetType = targetType;

		target = new ImageLoader(targetType+".png");
	}

	public String getTargetType(){
		return targetType;
	}

	public void draw(Graphics g) {
		target.draw(g, (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
	}

	public void edgeCollide(TargetArea box) {
		float targetMinX = box.getMinX() + radius;
		float targetMinY = box.getMinY() + radius;
		float targetMaxX = box.getMaxX() - radius;
		float targetMaxY = box.getMaxY() - radius;

		x += speedX;
		y += speedY;

		if (x < targetMinX) {
			speedX = -speedX;
			x = targetMinX;
		} else if (x > targetMaxX) {
			speedX = -speedX;
			x = targetMaxX;
		}

		if (y < targetMinY) {
			speedY = -speedY;
			y = targetMinY;
		} else if (y > targetMaxY) {
			speedY = -speedY;
			y = targetMaxY;
		}
	}
	
	public void targetCollide(Target target) {
		double distance = pytagoras(Math.abs(this.x - target.x), Math.abs(this.y - target.y));
		double truDist = this.radius + target.radius;
		
		if (distance < truDist) {
			this.speedX = -this.speedX;
			this.speedY = -this.speedY;
			target.speedX = -target.speedX;
			target.speedY = -target.speedY;
			
			this.x += this.speedX;
			this.y += this.speedY;
		}
	}
	
	public void overlap(Target target, int width, int height) {
		Random rand = new Random();
		double truDist = this.radius + target.radius;
		double distance;
		
		while (true) {
			distance = pytagoras(Math.abs(this.x - target.x), Math.abs(this.y - target.y));
			
			if (distance < truDist) {
				this.x = rand.nextInt((int) (width - this.radius * 2 - 20)) + this.radius + 10;
				this.y = rand.nextInt((int) (height - this.radius * 2 - 20)) + this.radius + 10;
			} else {
				break;
			}
		}
	}
		

	public double pytagoras(double r1, double r2) {
		return Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2));
	}

    public boolean intersect(int xTest, int yTest){
        if((xTest >= this.x-this.radius && xTest <= this.x+this.radius) && yTest >= this.y-this.radius && yTest <= this.y+this.radius){
            return true;
        }else{
            return false;
        }
    };
}
