package pf.kamek.zer0sound.pojos;

// This class contains the last command and some control methods
public class Command 
{

        private String command;

        public Command() 
        {
                this.command = "";
        }

        public Command(String command) 
        {
                this.command = command.toLowerCase();
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
