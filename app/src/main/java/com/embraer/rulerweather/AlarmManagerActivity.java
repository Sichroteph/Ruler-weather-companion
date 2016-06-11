package com.embraer.rulerweather;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;

public class AlarmManagerActivity extends Activity {

    private AlarmManagerBroadcastReceiver alarm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        alarm = new AlarmManagerBroadcastReceiver();

        Context context = this.getApplicationContext();
        if (alarm != null) {
            alarm.SetAlarm(context);
        } else {
            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
        }

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        Log.d(getClass().getName(), "battery value activity  =" + level);


        final UUID APP_UUID = UUID.fromString("25242f43-85c6-4966-9796-f9e6d4b653bb");
       
        PebbleDictionary outgoing = new PebbleDictionary();
        Log.d(getClass().getName(), "battery value activity  =" + level);
        outgoing.addInt32(105, level);
        PebbleKit.sendDataToPebble(this, APP_UUID, outgoing);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onResume() {

        super.onResume();

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        Log.d(getClass().getName(), "battery value activity  =" + level);


        final UUID APP_UUID = UUID.fromString("25242f43-85c6-4966-9796-f9e6d4b653bb");
        // Send a time and distance to the sports app
        PebbleDictionary outgoing = new PebbleDictionary();
        Log.d(getClass().getName(), "battery value activity  =" + level);
        outgoing.addInt32(105, level);
        PebbleKit.sendDataToPebble(this, APP_UUID, outgoing);

    }




}
