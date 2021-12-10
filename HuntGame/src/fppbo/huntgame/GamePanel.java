package fppbo.huntgame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseListener{

    private static final int REFRESH_RATE = 30;
	public List<Target> targets;
	private TargetArea box;
    private Score scores;
	private int areaWidth;
	private int areaHeight;
    private int radius;
	private int speed;

	private int t = 2; // banyak warna
	private Color[] color = { Color.GREEN, Color.RED};
	private int score = 0;
    
    public GamePanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(new Dimension(areaWidth, areaHeight));

		this.targets= new ArrayList<Target>();
		radius = 50;
		speed = 5;

        Random rand = new Random();
		makeTarget(color[rand.nextInt(t)]);

		box = new TargetArea(0, 0, width, height-50, Color.BLACK, Color.WHITE);
        scores = new Score(score, width, height);

        this.addMouseListener(this);
		this.setFocusable(true);
		startThread();
	}

    private void makeTarget(Color color) {
		Random rand = new Random();
		int x = rand.nextInt(areaWidth - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(areaHeight - radius * 2 - 20) + radius + 10;
		int angleInDegree = rand.nextInt(360);

		this.targets.add(new Target(x, y, radius, speed, angleInDegree, color));
	}

    private void clearTarget(){
        this.targets.remove(0);
    }

    private void updateScore(){
        if(this.targets.get(0).getColor() == Color.GREEN){
            this.score = this.score + 1;
            scores.setScore(score);
            repaint();
        }else{
            this.score = this.score - 1;
            scores.setScore(score);
            repaint();
        }
    }

    public void startThread() {
		Thread gameThread = new Thread() {
			public void run() {
				
				while (true) {
					for (Target b1 : targets) {
						b1.edgeCollide(box);

						for (Target b2 : targets) {
							if (b1.x == b2.x && b1.y == b2.y)
								continue;
							b1.targetCollide(b2);
							b1.overlap(b2, areaWidth, areaHeight);
						}
					}
					repaint();
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		gameThread.start();
	}

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		box.draw(g);
		for (Target target : targets) {
			target.draw(g);
		}
        scores.draw(g);
	}

    @Override
    public void mouseClicked(MouseEvent e) {

        boolean intersect = false;

        intersect = this.targets.get(0).intersect(e.getX(), e.getY());
        
        if(intersect == true){
            updateScore();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
