package fppbo.huntgame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundLoader {
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	public SoundLoader(String fileName) {
		this.setAudioInputStream(fileName);
		try {
			this.clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAudioInputStream(String fileName) {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("soundEffect/"+fileName).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playSound() {
		clip.start();
	}
	
	public void playLoopSound(int time) {
		clip.loop(time);
	}
	
	public void stopSound() {
		clip.stop();
		clip.flush();
	}
}
