package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class BroadCastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("asas","zazaz");
        context.startService(new Intent(context, service.class));;
        Log.d("asas","zazaz12");

    }
}