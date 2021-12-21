package fppbo.huntgame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fppbo.huntgame.Enums.STATE;

public class GamePanel extends JPanel implements MouseListener, KeyListener{

    private static final int REFRESH_RATE = 30;
    private Game game;

	public static final int WIDTH = 500, HEIGHT = 500;
	public static STATE gameState = STATE.Menu;
   
	
    public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		game = new Game();
		
        this.addMouseListener(this);
        this.addKeyListener(this);
		this.setFocusable(true);
	}

    public void startThread() {
		Thread gameThread = new Thread() {
			public void run() {
				while (true) {
					game.playReload();
					if(game.isOver()) {
						GamePanel.gameState = STATE.Over;
						repaint();
						break;
					}
					game.gameTargetsMove();
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
			game.gameStart(g);
			if(gameState == STATE.Over) {
				game.gameOver(g);				
			}
		}else if(gameState == STATE.Menu){
			game.gameMenu(g);
		} else if(gameState == STATE.Tutorial) {
			game.gameTutorial(g);
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
			if(e.getClickCount() == 1) {
				game.shoot(e.getX(), e.getY(), SwingUtilities.isLeftMouseButton(e), SwingUtilities.isRightMouseButton(e));
			}
			repaint();
		} else if(gameState == STATE.Menu){
			if(game.getMenu().getPlayButton().mouseOver(e.getX(), e.getY())){
				GamePanel.gameState = STATE.Tutorial;
				repaint();
			}else if(game.getMenu().getExitButton().mouseOver(e.getX(), e.getY())){
				System.exit(0);
			}
		} else if(gameState == STATE.Tutorial) {
			if(game.getTutorial().getNextButton().mouseOver(e.getX(), e.getY())) {
				GamePanel.gameState = STATE.Game;
				game.gameInit();
				startThread();
			}
		} else if(gameState == STATE.Over){
			if(game.getOver().getPlayAgainButton().mouseOver(e.getX(), e.getY())){
				GamePanel.gameState = STATE.Game;
				game.gameInit();
				startThread();
			}else if(game.getOver().getMenuButton().mouseOver(e.getX(), e.getY())){
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
				game.getPlayer().reloadAmmo();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
