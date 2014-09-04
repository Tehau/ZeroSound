package pf.kamek.zer0sound.services;

import pf.kamek.zer0sound.activities.MainScreen;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class VocalService extends AccessibilityService {

        @Override
        public void onAccessibilityEvent(AccessibilityEvent event) {
                String command = event.getText().toString();
                Log.d("zer0Sound", "[VocalService] : " + command);
                Intent intent = new Intent(this.getApplicationContext(), MainScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("command", command); 
                this.getApplicationContext().startActivity(intent);
        }

        @Override
        protected void onServiceConnected() {
                super.onServiceConnected();
        }

        @Override
        public void onInterrupt() {
                System.out.println("onInterrupt");
        }
}
