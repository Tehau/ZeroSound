package pf.kamek.zer0sound.activities;

import java.io.IOException;
import java.util.ArrayList;

import pf.kamek.zer0sound.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * A very simple application to handle Voice Recognition intents
 * and display the results
 */
public class MainScreen extends Activity
{

        private static final int REQUEST_CODE = 1234;
        private ListView wordsList;
        private AudioManager audioManager;

        /**
         * Called with the activity is first created.
         */
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.voice_recog);

                Button speakButton = (Button) findViewById(R.id.speakButton);
                Button muteButton = (Button) findViewById(R.id.muteButton);
                Button midVolumeButton = (Button) findViewById(R.id.midVolumeButton);
                Button nextButton = (Button) findViewById(R.id.nextButton);

                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                wordsList = (ListView) findViewById(R.id.list);
                Log.d("EUUUUURAAAAAAAAAAAAAAAAAAAAAAAAAX", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        }

        /**
         * Handle the action of the button being clicked
         */
        public void speakButtonClicked(View v)
        {
                startVoiceRecognitionActivity();
        }

        /**
         * Handle the action of the button being clicked
         */
        public void muteButtonClicked(View v)
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                0,
                                AudioManager.FLAG_VIBRATE);
        }

        /**
         * Handle the action of the button being clicked
         */
        public void midVolumeButtonClicked(View v)
        {
                audioManager.setStreamVolume(
                                AudioManager.STREAM_MUSIC, 
                                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 2,
                                AudioManager.FLAG_PLAY_SOUND);
        }

        /**
         * Handle the action of the button being clicked
         * @throws IOException
         * @throws IllegalStateException
         * @throws SecurityException
         * @throws IllegalArgumentException
         */
        public void nextButtonClicked(View v) throws IllegalArgumentException,
                        SecurityException, IllegalStateException, IOException        {
                Uri myUri = Uri.parse("content://com.maxmpz.audioplayer.data"); // initialize Uri here
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(getApplicationContext(), myUri);
                mediaPlayer.prepare();
                mediaPlayer.start();
        }

        /**
         * Fire an intent to start the voice recognition activity.
         */
        private void startVoiceRecognitionActivity()
        {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
                startActivityForResult(intent, REQUEST_CODE);
        }

        /**
         * Handle the results from the voice recognition activity.
         */
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
                if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
                        // Populate the wordsList with the String values the recognition engine thought it heard
                        ArrayList<String> matches = data.getStringArrayListExtra(
                                        RecognizerIntent.EXTRA_RESULTS);
                        wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                                                matches));
                }
                super.onActivityResult(requestCode, resultCode, data);
        }
}
