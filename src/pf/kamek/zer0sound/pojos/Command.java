package pf.kamek.zer0sound.pojos;

import pf.kamek.zer0sound.R;
import pf.kamek.zer0sound.activities.MainScreen;

import android.content.SharedPreferences;
import android.widget.TextView;

// This class contains the last command and some control methods
public class Command 
{

        private String command;
        private SharedPreferences prefs;
        private TextView lastCommand;

        public Command(MainScreen act, SharedPreferences prefs) 
        {
                this.command = new String();
                this.prefs = prefs;
                lastCommand = (TextView) act.findViewById(R.id.last_command);
        }

        // Gets rid of the "[]" that surrounds the command returned by Google Now
        public void strip() 
        {
                char first = command.charAt(0);
                char last = command.charAt(command.length() - 1);

                if (first == '[' && last == ']')
                        command = command.substring(1, command.length() - 1);
        }

        // Gets the number the user said when trying to change the volume
        public int getVolume()
        {
                int volume = 50;
                String[] tmp;

                if (command.contains("volume")) {
                        tmp = command.split(" "); 

                        // Trying to parse the last word as the volume
                        // "Set the volume to X"
                        try {
                                return Integer.parseInt(tmp[tmp.length - 1]);
                        } catch (NumberFormatException e) {
                                return volume;
                        }
                        
                }

                return volume;
        }

        /**
         * @return the command
         */
        public String getCommand() 
        {
                return command;
        }

        /**
         * @param command the command to set
         */
        public void setCommand(String command) 
        {
                this.command = command;
                strip();
                lastCommand.setText("< " + this.command + " >");
                prefs.edit().putString("lastCommand", lastCommand.getText().toString()).commit();
        }

}
