package main;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class sounds {
    Clip clip;
    URL soundURL[] = new URL[30];
    public boolean muted;

    public sounds(){
        soundURL[0] = getClass().getResource("/soundFiles/playerWalk.wav");
        soundURL[1] = getClass().getResource("/soundFiles/playerWalk2.wav");
        soundURL[2] = getClass().getResource("/soundFiles/playerWalk3.wav");
        soundURL[3] = getClass().getResource("/soundFiles/Metal Hit.wav");
        soundURL[4] = getClass().getResource("/soundFiles/peacefulBackgroundMusic.wav");
        soundURL[5] = getClass().getResource("/soundFiles/horrorsouds/Gasp.wav");
        soundURL[6] = getClass().getResource("/soundFiles/horrorsouds/Footsteps_walking.wav");
        soundURL[7] = getClass().getResource("/soundFiles/horrorsouds/Footsteps_running.wav");
        soundURL[8] = getClass().getResource("/soundFiles/horrorsouds/Breathing_fast.wav");
        soundURL[9] = getClass().getResource("/soundFiles/horrorsouds/Breathing_slow.wav");
        soundURL[10] = getClass().getResource("/soundFiles/horrorsouds/Gasp_3.wav");
        soundURL[11] = getClass().getResource("/soundFiles/horrorsouds/Metal_Twang.wav");
        
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
        if(!muted) {
            clip.start();
        }
    }
    public void stop(){
        clip.stop();
    }

    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public boolean isPlaying(){
        return clip != null && clip.isRunning();
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }
}
