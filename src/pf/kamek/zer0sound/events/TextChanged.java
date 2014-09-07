package pf.kamek.zer0sound.events;

import pf.kamek.zer0sound.pojos.Command;
import pf.kamek.zer0sound.pojos.Player;
import pf.kamek.zer0sound.pojos.Volume;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

// This class selects the appropriate action to trigger
// depending on what the user said
public class TextChanged implements TextWatcher
{


        private Context ctx;
        private Command command;
        private Volume volume;
        private Player player;

        public TextChanged(Context ctx, Command command)
        {
                this.ctx = ctx;
                this.command = command;
                this.volume = new Volume(ctx);
                this.player = new Player(ctx);
        }

        // If the texts changes, then a new command has been received
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) 
        {
                String c = command.getCommand();

                if (c.contains("volume")) {
                        if (c.contains("raise")) {
                                clearStack();
                                volume.raiseVolume();
                                Toast.makeText(ctx, "Volume raised", Toast.LENGTH_SHORT).show();
                        } else if (c.contains("lower")) {
                                clearStack();
                                volume.lowerVolume();
                                Toast.makeText(ctx, "Volume lowered", Toast.LENGTH_SHORT).show();
                        } else {
                                volume.setVolume(command.getVolume());
                                Toast.makeText(ctx, "Volume changed to " + command.getVolume(), Toast.LENGTH_SHORT).show();
                        }
                } else if (c.contains("play") || c.contains("playback")) {
                        if (c.contains("music"))
                                clearStack();
                        player.Play();
                        Toast.makeText(ctx, "Playing music", Toast.LENGTH_SHORT).show();
                } else if (c.contains("pause") || c.contains("stop")) {
                        player.Pause();
                        Toast.makeText(ctx, "Music paused", Toast.LENGTH_SHORT).show();
                } else if (c.contains("next") || c.contains("skip")) {
                        player.Next();
                        Toast.makeText(ctx, "Playing next track", Toast.LENGTH_SHORT).show();
                } else if (c.contains("previous") || c.contains("back")) {
                        player.Previous();
                        Toast.makeText(ctx, "Playing previous track", Toast.LENGTH_SHORT).show();
                } else if (c.contains("shuffle")) { 
                        player.Shuffle();
                        Toast.makeText(ctx, "Playlist shuffled", Toast.LENGTH_SHORT).show();
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
