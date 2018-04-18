package com.build.proto.testschema;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.EXTRA_DOCK_STATE;
import static android.content.Intent.EXTRA_DOCK_STATE_CAR;
import static android.content.Intent.EXTRA_DOCK_STATE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_HE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_LE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_UNDOCKED;

public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOnClick();
                postMessage();
                dumpMemory();
            }
        });

    }

    void handleOnClick() {
        // 底座
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_DOCK_EVENT);
        Intent dockStatus = registerReceiver(null, ifilter);
        if (dockStatus != null) {
            int dockState = dockStatus.getIntExtra(EXTRA_DOCK_STATE, EXTRA_DOCK_STATE_UNDOCKED);
            boolean isDocked = dockState != EXTRA_DOCK_STATE_UNDOCKED;


            boolean isCar = dockState == EXTRA_DOCK_STATE_CAR;
            boolean isDesk = dockState == EXTRA_DOCK_STATE_DESK ||
                    dockState == EXTRA_DOCK_STATE_LE_DESK ||
                    dockState == EXTRA_DOCK_STATE_HE_DESK;


            Log.e("Ruby", "isDocked = " + isDocked + " ,isDesk = " + isDesk + " , isCar= " + isCar);
        } else {
            Log.e("Ruby", "dockStatus is null");
        }

        // 电池
        IntentFilter battery = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, battery);
        // Are we charging / charged?
        if (batteryStatus != null) {
            int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL;

            // How are we charging?
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPct = level / (float) scale * 100;
            Log.e("Ruby", "isCharging = " + isCharging + " ,usbCharge = " + usbCharge + " , acCharge= " + acCharge + " ，batteryPct" + batteryPct + "%");
        } else {
            Log.e("Ruby", "batteryStatus is null");
        }
    }

    private void postMessage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("Ruby", "As You See");
            }
        }, 24 * 60 * 1000);
    }

    private void dumpMemory() {
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        Log.e("Ruby", "getLargeMemoryClass() = " + am.getLargeMemoryClass());
    }
}
