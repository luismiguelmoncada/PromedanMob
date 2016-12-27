package com.evolution.promedan.promedanmob;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by LUISM on 22/12/2016.
 */

public  class MyFirebaseMessagingService  extends FirebaseMessagingService {

    private static final String TAG = "FIREBASE Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.e(TAG, "From: " + remoteMessage.getFrom());
        }
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Message Notification data :" + remoteMessage.getData());
        }
    }
}
