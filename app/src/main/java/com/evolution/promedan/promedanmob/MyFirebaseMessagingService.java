package com.evolution.promedan.promedanmob;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by LUISM on 22/12/2016.
 */

public  class MyFirebaseMessagingService  extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.e("FIREBASE", remoteMessage.getNotification().getBody());
    }
}
