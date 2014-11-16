package me.zerocore.zerosound.activities;

import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import me.zerocore.zerosound.R;
import me.zerocore.zerosound.events.TextChanged;
import me.zerocore.zerosound.pojos.Command;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainScreen extends Activity
{

        private TextView lastCommand;
        private Command command;
        private SharedPreferences prefs;
        public boolean refresh;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main_screen);

                prefs = getSharedPreferences("me.zerocore.zerosound.core", MODE_PRIVATE);

                command = new Command(this, prefs);
                lastCommand = (TextView) this.findViewById(R.id.last_command);
                lastCommand.setText(prefs.getString("lastCommand", "< no previous command >"));
                lastCommand.addTextChangedListener(new TextChanged(this, command));
        }

        protected void onResume()
        {
                super.onResume();

                if (prefs.getBoolean("refresh", true)) {

                        String receivedCommand;
                        receivedCommand = new String() + this.getIntent().getStringExtra("command");

                        if (!receivedCommand.equals("null") && !receivedCommand.equals("[]"))
                                command.setCommand(receivedCommand);

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_options, menu);

		return true;
	}

	// Handles menu item clicks
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.zerocore) {
			String url = "http://zerocore.me";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		}

		return super.onOptionsItemSelected(item);
	}
}
