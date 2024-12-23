package main;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class sounds {
    Clip clip;
    URL soundURL[] = new URL[30];

    public sounds(){
        soundURL[0] = getClass().getResource("/soundFiles/playerWalk.wav");
        soundURL[1] = getClass().getResource("/soundFiles/playerWalk2.wav");
        soundURL[2] = getClass().getResource("/soundFiles/playerWalk3.wav");
        soundURL[3] = getClass().getResource("/soundFiles/Metal Hit.wav");
        soundURL[4] = getClass().getResource("/soundFiles/peacefulBackgroundMusic.wav");
    }

    public void setSound(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void play(){
        clip.start();
    }
    public void stop(){
        clip.stop();
    }

    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
}