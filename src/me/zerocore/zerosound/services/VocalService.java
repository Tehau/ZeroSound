package me.zerocore.zerosound.services;


import me.zerocore.zerosound.activities.MainScreen;
import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

// Service used to read from Google Now
public class VocalService extends AccessibilityService
{

    	@Override
        public void onAccessibilityEvent(AccessibilityEvent event)
        {
                String command = event.getText().toString();

                Intent intent = new Intent(this.getApplicationContext(), MainScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("command", command);

                this.getApplicationContext().startActivity(intent);
                Log.d("zer0Sound","service intent fired");
        }

        @Override
        protected void onServiceConnected()
        {
                super.onServiceConnected();
        }

        @Override
        public void onInterrupt()
        {
                System.out.println("onInterrupt");
        }
}
