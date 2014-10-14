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
                                volume.raiseVolume();
                        } else if (c.contains("lower")) {
                                volume.lowerVolume();
                        } else {
                                volume.setVolume(command.getVolume());
                        }
                } else if (c.contains("play") || c.contains("playback")) {
                        player.Play();
                } else if (c.contains("stop")) {
                        player.Pause();
                } else if (c.contains("next") || c.contains("skip")) {
                        player.Next();
                } else if (c.contains("previous") || c.contains("back")) {
                        player.Previous();
                } else if (c.contains("shuffle")) {
                        player.Shuffle();
                }

                clearStack();
        }

        public void clearStack()
        {
                Intent i;
                String GOOGLE_PKG = "com.google.android.googlequicksearchbox";
                PackageManager manager = ctx.getPackageManager();
                try {
                        i = manager.getLaunchIntentForPackage(GOOGLE_PKG);
                        if (i == null)
                                throw new PackageManager.NameNotFoundException();
                        i.addCategory(Intent.CATEGORY_LAUNCHER);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                        ctx.startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {

                }
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
