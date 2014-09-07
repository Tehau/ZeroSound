package pf.kamek.zer0sound.pojos;

import android.content.Context;
import android.media.AudioManager;

// This class handles volume modifications
public class Volume 
{

        private AudioManager audioManager;
        private int maxVolume;

        public Volume(Context c) 
        {
                audioManager = (AudioManager) c.getSystemService(Context.AUDIO_SERVICE);
                maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        }

        // Changes volume to a specific value, 0 being the minimum and 100 the maximum
        public void setVolume(int volume)
        {
                if (volume >= 0 && volume <= 100) {
                        audioManager.setStreamVolume(
                                        AudioManager.STREAM_MUSIC, 
                                        maxVolume * volume / 100,
                                        AudioManager.FLAG_PLAY_SOUND);
                }
        }

        public void raiseVolume()
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                AudioManager.ADJUST_RAISE, 
                                AudioManager.FLAG_PLAY_SOUND);
        }

        public void lowerVolume()
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                AudioManager.ADJUST_LOWER, 
                                AudioManager.FLAG_PLAY_SOUND);
        }


}
