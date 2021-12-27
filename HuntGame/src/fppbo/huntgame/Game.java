package fppbo.huntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import fppbo.huntgame.Components.Background;
import fppbo.huntgame.Components.Player;
import fppbo.huntgame.Components.Target;
import fppbo.huntgame.Components.TargetArea;
import fppbo.huntgame.Pages.Menu;
import fppbo.huntgame.Pages.Over;
import fppbo.huntgame.Pages.Tutorial;
import fppbo.huntgame.Services.SoundLoader;

public class Game {
	private Background bg;
	private Player player;
	private Menu menu;
	private TargetArea box;
	private Tutorial tutorial;
	private Timer timer;
	private Over over;
	private int time;
	private final SoundLoader reloadSound = new SoundLoader("reload.wav");
	private final Random rand = new Random();
	public List<Target> targets;
	private final int t = 5; // banyak jenis target
	private final String[] targetType = {"bomb", "chicken", "sheep", "pig", "bear"};
	
	public Game() {
		this.player = new Player();
		this.menu = new Menu();
		this.box = new TargetArea(0+25, 0+25, GamePanel.WIDTH-50, GamePanel.HEIGHT-80);
		this.tutorial = new Tutorial();
		this.over = new Over(player);
		this.targets = new ArrayList<Target>();
		this.bg = new Background();
	}
	
	public Player getPlayer() {
		return player;
	}

	public void makeTarget(String targetType) {
		int radius = Math.abs(rand.nextInt())%11+40;
		int speed = Math.abs(rand.nextInt())%4+5;
		int x = rand.nextInt(GamePanel.WIDTH - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(GamePanel.HEIGHT - radius * 2 - 20) + radius + 10;
		int angleInDegree = rand.nextInt(360);

		targets.add(new Target(x, y, radius, speed, angleInDegree, targetType));
	}
	
	public void updateScore(){
		player.updateScore(targets.get(0));
    }
	
	public void playReload() {
		if(player.getAmmo()==0) {
			reloadSound.playLoopSound(1);
		} else {
			reloadSound.stopSound();	
		}
	}
	
	public boolean isOver() {
		if(time<0) {
			return true;
		}
		return false;
	}
	
	public void gameTargetsMove() {
		for (Target b1 : targets) {
			b1.edgeCollide(box);
		}
	}
	
	public void shoot(int x, int y, boolean isLeft, boolean isRight) {
		boolean intersect = false;
		intersect = this.targets.get(0).intersect(x, y);
		if(intersect == true && player.getAmmo()>0){
			if(player.getAmmo()>0 && isLeft && !isRight) {
				updateScore();
			}
			targets.remove(0);
			makeTarget(targetType[rand.nextInt(t)]);
		}
		player.useAmmo();
	}
	
	public Menu getMenu() {
		return menu;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public Over getOver() {
		return over;
	}
	
	public void gameInit() {
		player.getScore().setScore(0);
		player.reloadAmmo();
		for(int i=targets.size(); i>0; i--){
			targets.remove(0);
		}
		makeTarget(targetType[rand.nextInt(t)]);
		this.timer = new Timer();
		time = 5;

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
	
	public void gameStart(Graphics g) {
		bg.draw(g);
		box.draw(g);
		Font smallFont = new Font("Helvetica", Font.BOLD, 14);
		g.setFont(smallFont);
        g.setColor(new Color(67, 221, 226));
		g.drawString("Time: " + time, GamePanel.WIDTH/2-30, GamePanel.HEIGHT - 25);
		for (Target target : targets) {
			target.draw(g);
		}
		player.draw(g);
	}
	
	public void gameOver(Graphics g) {
		over.draw(g);
	}
	
	public void gameMenu(Graphics g) {
		menu.draw(g);
	}
	
	public void gameTutorial(Graphics g) {
		tutorial.draw(g);
	}
}
