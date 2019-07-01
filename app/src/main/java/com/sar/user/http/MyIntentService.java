package com.sar.user.http;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;


public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Uri uri=intent.getData();
        String ab;
        try {
           ab=Data.downurl(uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
            ab=e.getMessage().toString();
        }

      Gson gson=new Gson();
      CityItem[] cityItems=gson.fromJson(ab,CityItem[].class);
            sendMessageui(cityItems);
    }


    private void sendMessageui(CityItem [] cityItems) {
        Intent intent=new Intent("hlo");
        intent.putExtra("kk",cityItems);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);



    }


}
