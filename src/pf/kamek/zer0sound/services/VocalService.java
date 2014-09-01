package pf.kamek.zer0sound.services;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class VocalService extends AccessibilityService {
        @Override
        public void onAccessibilityEvent(AccessibilityEvent event) {
                Log.d("zer0Sound", "Event : " + event.getText().toString());
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
