package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import androidx.annotation.Nullable;

public class service extends Service {



    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        try {
            startService(restartServiceIntent);
        } catch (Exception e) {
//            Log.d("Error",e.getMessage());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
        Log.d("hsadfgysda", "shjdfgdsfdsf");

        long date = System.currentTimeMillis();

        SimpleDateFormat hour = new SimpleDateFormat(" h");
        SimpleDateFormat minutes = new SimpleDateFormat("m");
        SimpleDateFormat month = new SimpleDateFormat(" MM");
        SimpleDateFormat dates = new SimpleDateFormat("dd");

        String mHour = hour.format(new Date(Long.parseLong(String.valueOf(date))));
        String mMinutes = minutes.format(new Date(Long.parseLong(String.valueOf(date))));
        String mMonth = month.format(new Date(Long.parseLong(String.valueOf(date))));
        String mDay = dates.format(new Date(Long.parseLong(String.valueOf(date))));


//        this logic is for birthday wishes only and  new year.

//       if(current_time = 11:50 pm) this will make sure you dont request for data everytime
//        {
//            fethc data from db
//        }

//        fMonth = Retrieve time from firebase which is in milliseconds and get hour, minutes seperately .
//        then check with the current month and date
//       fDate-1 because we have to sent birthday wished one day prior

//      if(mMonth=fMonth && mDates = fDate-1 ){
//        if(current_time == 11:50 ){
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage("+917400380284", null, "sms testing", null, null);
//            }
//         }

        Log.d("hsadfgysda","shjdfgdsfdsf"+mHour+mMinutes+"     ");

        onTaskRemoved(intent);
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
