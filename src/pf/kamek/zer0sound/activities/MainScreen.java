package pf.kamek.zer0sound.activities;

import pf.kamek.zer0sound.R;
import pf.kamek.zer0sound.events.TextChanged;
import pf.kamek.zer0sound.pojos.Command;
import pf.kamek.zer0sound.pojos.Volume;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainScreen extends Activity
{

        private TextView lastCommand;
        private Command command;
        private Volume volume;
        private Context c;
        private SharedPreferences prefs;
        public boolean refresh;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main_screen);

                c = this.getApplicationContext();
                prefs = getSharedPreferences("pf.kamek.zer0Sound.core", MODE_PRIVATE);

                volume = new Volume(c);
                command = new Command();

                lastCommand = (TextView) this.findViewById(R.id.last_command);
                lastCommand.setText(prefs.getString("lastCommand", "< no previous command >"));
                lastCommand.addTextChangedListener(new TextChanged(command, volume)); 
        }

        protected void onResume() 
        {
                super.onResume();

                if (prefs.getBoolean("refresh", true)) {

                        String receivedCommand, displayCommand;
                        receivedCommand = new String("" + this.getIntent().getStringExtra("command")); 

                        if (!receivedCommand.equals("null") && !receivedCommand.equals("[]")) {
                                command.setCommand(receivedCommand);
                                command.strip();

                                displayCommand = new String("< " + command.getCommand() + " >");

                                prefs.edit().putString("lastCommand", displayCommand).commit();
                                lastCommand.setText(displayCommand);
                        }

                        prefs.edit().putBoolean("refresh", false).commit();
                }
        }

        @Override
        protected void onNewIntent(Intent intent) 
        {
                super.onNewIntent(intent);
                this.setIntent(intent);
                prefs.edit().putBoolean("refresh", true).commit();
        }
}
