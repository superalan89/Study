package net.flow9.broadcastreceiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
    1. 리시버를 동적으로 사용할 때는 start 와 stop 에서 각각 regist 처리를 해야한다.
    2. 항상 사용할 때는 매니페스트에 등록해주면 된다.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 여기서 넘오온 intent를 받아서 처리한다 끝~
    }

    BroadcastReceiver receiver;
    IntentFilter intentFilter;
    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}
