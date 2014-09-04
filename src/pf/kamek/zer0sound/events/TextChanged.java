package pf.kamek.zer0sound.events;

import pf.kamek.zer0sound.pojos.Command;
import pf.kamek.zer0sound.pojos.Volume;

import android.text.Editable;
import android.text.TextWatcher;

// This class selects the appropriate action to trigger
// depending on what the user said
public class TextChanged implements TextWatcher
{

        private Command command;
        private Volume volume;

        public TextChanged(Command command, Volume volume) 
        {
                this.command = command;
                this.volume = volume;
        }

        // If the texts changes, then a new command has been received
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) 
        {
                if (command.containsVolume())
                        volume.setVolumeTo(command.getVolume());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) 
        {

        }

        @Override
        public void afterTextChanged(Editable s) 
        {

        }

}
