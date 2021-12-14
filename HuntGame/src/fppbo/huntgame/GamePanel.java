package fppbo.huntgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel implements MouseListener, KeyListener{

    private static final int REFRESH_RATE = 30;
	public List<Target> targets;
	private TargetArea box;
	private Player player;
    private Score scores;
	private Menu menu;
	private Tutorial tutorial;
	private Timer timer;
	private Over over;
	private int score;
	private int time;

	private int t = 2; // banyak warna
	private Color[] color = { Color.GREEN, Color.RED};
	private Random rand;

	public static final int WIDTH = 500, HEIGHT = 500;
	public static STATE gameState = STATE.Menu;
    
	private final SoundLoader reloadSound = new SoundLoader("reload.wav");
	
    public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		rand = new Random();
		menu = new Menu();
		tutorial = new Tutorial();
		
        this.addMouseListener(this);
        this.addKeyListener(this);
		this.setFocusable(true);
	}

	private void Init(){
		box = new TargetArea(0, 0, WIDTH, HEIGHT-30, Color.BLACK, Color.WHITE);
        scores = new Score(score, WIDTH, HEIGHT);
		over = new Over(scores);
        player = new Player("Anto", scores, WIDTH, HEIGHT);
        timer = new Timer();
        scores.setScore(0);
		time = 60;
		targets = new ArrayList<Target>();

		for(int i=targets.size(); i>0; i--){
			clearTarget();
		}
		makeTarget(color[rand.nextInt(t)]);

        timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				time--;
				if(time<0) {
					timer.cancel();
				}
			}
		}, 0, 1000);
	}

    private void makeTarget(Color color) {
		int radius = Math.abs(rand.nextInt())%11+40;
		int speed = Math.abs(rand.nextInt())%4+5;
		int x = rand.nextInt(WIDTH - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(HEIGHT - radius * 2 - 20) + radius + 10;
		int angleInDegree = rand.nextInt(360);

		targets.add(new Target(x, y, radius, speed, angleInDegree, color));
	}

    private void clearTarget(){
        targets.remove(0);
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
					if(player.getAmmo()==0) {
						reloadSound.playLoopSound(1);
					} else {
						reloadSound.stopSound();	
					}
					if(time<0) {
						GamePanel.gameState = STATE.Over;
						repaint();
						break;
					}
					for (Target b1 : targets) {
						b1.edgeCollide(box);

						for (Target b2 : targets) {
							if (b1.x == b2.x && b1.y == b2.y)
								continue;
							b1.targetCollide(b2);
							b1.overlap(b2, WIDTH, HEIGHT);
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

		if(gameState == STATE.Game||gameState == STATE.Over){
			box.draw(g);
			Font smallFont = new Font("Helvetica", Font.BOLD, 14);
			g.setFont(smallFont);
	        g.setColor(new Color(96, 128, 255));
			g.drawString("Time: " + time, WIDTH/2-30, HEIGHT - 10);
			for (Target target : targets) {
				target.draw(g);
			}
			scores.draw(g);
			player.draw(g);
			if(gameState == STATE.Over) {
				over.draw(g);				
			}
		}else if(gameState == STATE.Menu){
			menu.draw(g);
		} else if(gameState == STATE.Tutorial) {
			tutorial.draw(g);
		}
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        //DO Something
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
		if(gameState == STATE.Game){
			boolean intersect = false;
			
			intersect = this.targets.get(0).intersect(e.getX(), e.getY());
			if(intersect == true && player.getAmmo()>0){
				if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
					if(player.getAmmo()>0) {
						updateScore();
					}
				}
				clearTarget();
				makeTarget(color[rand.nextInt(t)]);
			}
			player.useAmmo();   		
			repaint();
		}else if(gameState == STATE.Menu){
			if(menu.mouseOver(e.getX(), e.getY(), GamePanel.WIDTH/2 - 75, 225, 150, 50) == true){
				GamePanel.gameState = STATE.Tutorial;
				repaint();
			}else if(menu.mouseOver(e.getX(), e.getY(), GamePanel.WIDTH/2 - 75, 325, 150, 50) == true){
				System.exit(0);
			}
		} else if(gameState == STATE.Tutorial) {
			if(tutorial.mouseOver(e.getX(), e.getY(), 175, 370, 150, 50)) {
				GamePanel.gameState = STATE.Game;
				Init();
				startThread();
			}
		} else if(gameState == STATE.Over){
			if(menu.mouseOver(e.getX(), e.getY(), GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 30, 150, 40) == true){
				GamePanel.gameState = STATE.Game;
				Init();
				startThread();
			}else if(menu.mouseOver(e.getX(), e.getY(), GamePanel.WIDTH/2 - 75, GamePanel.HEIGHT/2 + 80, 150, 40) == true){
				GamePanel.gameState = STATE.Menu;
				repaint();
			}
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(gameState==STATE.Game) {
			char key = e.getKeyChar();			
			if(key=='r'||key=='R') {
				player.reloadAmmo();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
