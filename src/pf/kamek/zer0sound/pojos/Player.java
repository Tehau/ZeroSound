package pf.kamek.zer0sound.pojos;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.maxmpz.poweramp.player.PowerampAPI;

public class Player
{
        private Context ctx;

        public Player(Context ctx)
        {
                this.ctx = ctx;
        }

        public void Play()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.TOGGLE_PLAY_PAUSE);
                ctx.startService(intent);
                Toast.makeText(ctx, "Playing music", Toast.LENGTH_SHORT).show();
        }

        public void Pause()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.PAUSE);
                ctx.startService(intent);
                Toast.makeText(ctx, "Music paused", Toast.LENGTH_SHORT).show();
        }

        public void Next()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.NEXT);
                ctx.startService(intent);
                Toast.makeText(ctx, "Playing next track", Toast.LENGTH_SHORT).show();
        }

        public void Previous()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.PREVIOUS);
                ctx.startService(intent);
                Toast.makeText(ctx, "Playing previous track", Toast.LENGTH_SHORT).show();
        }

        public void Shuffle()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.SHUFFLE);
                ctx.startService(intent);
                Toast.makeText(ctx, "Playlist shuffled", Toast.LENGTH_SHORT).show();
        }
}
