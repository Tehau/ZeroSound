package pf.kamek.zer0sound.events;

import pf.kamek.zer0sound.pojos.Command;
import pf.kamek.zer0sound.pojos.Player;
import pf.kamek.zer0sound.pojos.Volume;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.Editable;
import android.text.TextWatcher;

// This class selects the appropriate action to trigger
// depending on what the user said
public class TextChanged implements TextWatcher
{

        private Context ctx;
        private Command command;
        private Volume volume;
        private Player player;

        public TextChanged(Context ctx, Command command, Volume volume, Player player) 
        {
                this.ctx = ctx;
                this.command = command;
                this.volume = volume;
                this.player = player;
        }

        // If the texts changes, then a new command has been received
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) 
        {
                if (command.containsVolume()) {
                        if (command.containsRaise()) {
                                clearStack();
                                volume.raiseVolume();
                        } else if (command.containsLower()) {
                                clearStack();
                                volume.lowerVolume();
                        } else {
                                volume.setVolume(command.getVolume());
                        }
                } else if (command.containsPlay()) {
                        if (command.containsPlayMusic())
                                clearStack();
                        player.Play();
                } else if (command.containsPause()) {
                        player.Pause();
                } else if (command.containsNext()) {
                        player.Next();
                } else if (command.containsPrevious()) {
                        player.Previous();
                } else if (command.containsShuffle()) {
                        player.Shuffle();
                }
        }

        public void clearStack()
        {
                PackageManager manager = ctx.getPackageManager();
                Intent intent = manager.getLaunchIntentForPackage("com.google.android.googlequicksearchbox");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ctx.startActivity(intent);
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
