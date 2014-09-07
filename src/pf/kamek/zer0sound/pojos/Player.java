package pf.kamek.zer0sound.pojos;

import android.content.Context;
import android.content.Intent;

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
        }

        public void Pause()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.PAUSE);
                ctx.startService(intent);
        }

        public void Next()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.NEXT);
                ctx.startService(intent);
        }

        public void Previous()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.PREVIOUS);
                ctx.startService(intent);
        }

        public void Shuffle()
        {
                Intent intent = new Intent(PowerampAPI.ACTION_API_COMMAND);
                intent.putExtra(PowerampAPI.COMMAND, PowerampAPI.Commands.SHUFFLE);
                ctx.startService(intent);
        }
}
