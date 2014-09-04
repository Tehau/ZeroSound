package pf.kamek.zer0sound.activities;

import pf.kamek.zer0sound.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainScreen extends Activity
{

        private AudioManager audioManager;
        private TextView lastCommand;
        private Bundle extras;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                Log.d("zer0Sound", "[MainScreen] :  onCreate() called");
                setContentView(R.layout.main_screen);

                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                lastCommand = (TextView) this.findViewById(R.id.last_command);
                lastCommand.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void afterTextChanged(Editable s) {
                                // TODO Auto-generated method stub

                        }

                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                // TODO Auto-generated method stub

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                                Log.d("zer0Sound", "[MainScreen] : last command changed");
                        } 

                });
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

        protected void onResume() {
                // TODO Auto-generated method stub
                super.onResume();
                Log.d("zer0Sound", "[MainScreen] :  onResume() called");
                extras = this.getIntent().getExtras(); 
                if (extras != null)
                {
                        Log.d("zer0Sound", "[MainScreen] : intent received : " + extras.getString("command"));
                        if(extras.getString("command") != "[]")
                                lastCommand.setText(extras.getString("command"));
                }
        }

        @Override
        protected void onNewIntent(Intent intent) {
                // TODO Auto-generated method stub
                super.onNewIntent(intent);
                this.setIntent(intent);
                Log.d("zer0Sound", "[MainScreen] :  onNewIntent() called");
        }
}
