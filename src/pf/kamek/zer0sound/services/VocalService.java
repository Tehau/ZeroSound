package pf.kamek.zer0sound.services;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class VocalService extends AccessibilityService {
        @Override
        public void onAccessibilityEvent(AccessibilityEvent event) {
                Log.d("zer0Sound", "Event : " + event.getText().toString());
        }

        @Override
        protected void onServiceConnected() {
                AccessibilityServiceInfo info = new AccessibilityServiceInfo();
                info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
                info.feedbackType = AccessibilityServiceInfo.DEFAULT;
                setServiceInfo(info);
        }

        @Override
        public void onInterrupt() {
                System.out.println("onInterrupt");
        }
}
