package pf.kamek.zer0sound.pojos;

import java.util.Locale;

// This class contains the last command and some control methods
public class Command 
{

        private String command;

        public Command() 
        {
                this.command = new String();
        }

        public Command(String command) 
        {
                this.command = new String() + 
                		command.toLowerCase(new Locale(command));
                
                strip();
        }

        // Gets rid of the "[]" that surrounds the command returned by Google Now
        public void strip() 
        {
                char first = command.charAt(0);
                char last = command.charAt(command.length() - 1);

                if (first == '[' && last == ']')
                        command = command.substring(1, command.length() - 1);
        }

        // Checks if the user said the word "volume"
        public boolean containsVolume()
        {
                if (command.contains("volume"))
                        return true;
                else
                        return false;
        }

        // Checks if the user said the word "raise"
        public boolean containsRaise()
        {
                if (command.contains("raise"))
                        return true;
                else
                        return false;
        }

        // Checks if the user said the word "lower"
        public boolean containsLower()
        {
                if (command.contains("lower"))
                        return true;
                else
                        return false;
        }

        // Checks if the user said the word "play" or "playback"
        public boolean containsPlay()
        {
                if (command.contains("play") || command.contains("playback"))
                {
                    return true;
                }
                else
                        return false;
        }

        // Checks if the user said the word "play" and "music"
        public boolean containsPlayMusic()
        {
                if (command.contains("play") && command.contains("music"))
                {
                    return true;
                }
                else
                        return false;
        }

        // Checks if the user said the word "stop"
        public boolean containsPause()
        {
                if (command.contains("stop") || command.contains("pause"))
                        return true;
                else
                        return false;
        }

        // Checks if the user said the word "next"
        public boolean containsNext()
        {
                if (command.contains("next"))
                        return true;
                else
                        return false;
        }


        // Checks if the user said the word "previous"
        public boolean containsPrevious()
        {
                if (command.contains("previous") || command.contains("back"))
                        return true;
                else
                        return false;
        }

        // Checks if the user said the word "previous"
        public boolean containsShuffle()
        {
                if (command.contains("shuffle"))
                        return true;
                else
                        return false;
        }

        // Gets the number the user said when trying to change the volume
        public int getVolume()
        {
                int volume = 50;
                String[] tmp;

                if (containsVolume())
                {
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
        }

}
