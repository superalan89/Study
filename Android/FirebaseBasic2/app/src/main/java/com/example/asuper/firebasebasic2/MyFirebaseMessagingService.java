package com.example.asuper.firebasebasic2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by super on 2017-10-31.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MsgService";

    // 내 앱이 화면에 현재 떠있으면 noti가 전송됬을 때 이 함수가 호출된다.
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            // 여기서 노티피케이션 메시지를 받아서 처리
        }
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        String type = "";
        Map map = remoteMessage.getData();
        if(map != null)
            type = map.get("type") != null ? (String)map.get("type"):"";


        /*  MediaPlayer player;
        switch(type) {
            case "one":
                player = MediaPlayer.create(getBaseContext(), R.raw.Alarm01);
                break;
            case "two":
                player = MediaPlayer.create(getBaseContext(), R.raw.Alarm02);
                break;
        }
        player.setLooping(false);*/


    }


    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "DEFAULT CHANNEL";

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("FCM Message")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}