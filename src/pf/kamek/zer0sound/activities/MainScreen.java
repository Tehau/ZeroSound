package pf.kamek.zer0sound.activities;

import pf.kamek.zer0sound.R;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends Activity
{

        private AudioManager audioManager;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main_screen);
                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }

        public void muteButtonClicked(View v)
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                0,
                                AudioManager.FLAG_VIBRATE);
        }

        public void midVolumeButtonClicked(View v)
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 2,
                                AudioManager.FLAG_PLAY_SOUND);
        }
}
