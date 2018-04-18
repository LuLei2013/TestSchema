package com.build.proto.testschema;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Intent.EXTRA_DOCK_STATE;
import static android.content.Intent.EXTRA_DOCK_STATE_CAR;
import static android.content.Intent.EXTRA_DOCK_STATE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_HE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_LE_DESK;
import static android.content.Intent.EXTRA_DOCK_STATE_UNDOCKED;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent dockStatus) {
        if (dockStatus != null) {
            int dockState = dockStatus.getIntExtra(EXTRA_DOCK_STATE, EXTRA_DOCK_STATE_UNDOCKED);
            boolean isDocked = dockState != EXTRA_DOCK_STATE_UNDOCKED;


            boolean isCar = dockState == EXTRA_DOCK_STATE_CAR;
            boolean isDesk = dockState == EXTRA_DOCK_STATE_DESK ||
                    dockState == EXTRA_DOCK_STATE_LE_DESK ||
                    dockState == EXTRA_DOCK_STATE_HE_DESK;


            Log.e("Ruby", "22222 isDocked = " + isDocked + " ,isDesk = " + isDesk + " , isCar= " + isCar);
        } else {
            Log.e("Ruby", "22222  dockStatus is null");
        }
    }
}
