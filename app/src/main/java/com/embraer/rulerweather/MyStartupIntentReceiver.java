package com.embraer.rulerweather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;


public class MyStartupIntentReceiver extends BroadcastReceiver {
    //public static final String TAG = "com.batutils.batpercent";
    private AlarmManagerBroadcastReceiver alarm;
    @Override

    public void onReceive(Context context, Intent intent) {

        Log.d("Autostart", "started !");
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent i = new Intent(context, AlarmManagerActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);



        } else {
        }

    }


}


