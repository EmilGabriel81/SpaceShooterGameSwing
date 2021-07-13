package com.schooluniversity.sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundCreator {
	private Clip clip;

	public SoundCreator() {

	}

	public void bullet() {
		
		try {
      AudioInputStream audioInStream = AudioSystem.getAudioInputStream(new File("sounds/laserfire02.wav"));
      clip = AudioSystem.getClip();
      clip.open(audioInStream);
      clip.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
public void explosion() {
		
		try {
      AudioInputStream audioInStream = AudioSystem.getAudioInputStream(new File("sounds/whip.wav"));
      clip = AudioSystem.getClip();
      clip.open(audioInStream);
      clip.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
