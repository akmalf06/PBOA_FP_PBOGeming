package fppbo.huntgame;

import javax.swing.JFrame;

public class Main {
 
    public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("AIM BOT");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new GamePanel());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
