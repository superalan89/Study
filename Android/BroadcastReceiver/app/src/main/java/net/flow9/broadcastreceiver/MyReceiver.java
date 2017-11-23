package net.flow9.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 1. 등록된 리시버를 통해 브로드캐스트 메시지가 intent에 담겨 넘어온다
        if("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            Object msgs[] = (Object[]) bundle.get("pdus");

            SmsMessage smsMessage[] = new SmsMessage[msgs.length];
            for (int i = 0; i < msgs.length; i++) {
                smsMessage[i] = SmsMessage.createFromPdu((byte[]) msgs[i]);
                String msg = smsMessage[i].getMessageBody().toString();
                Log.i("Broadcast", "SMS=" + msg);

                /*
                [국민은행] 인증번호를 입력해주세요
                인증번호 : 8765
                 */

                if(msg.startsWith("[국민은행]")){
                    String verification_number =  msg.split(" : ")[1];
                    Intent mIntent = new Intent(context, MainActivity.class);
                    mIntent.putExtra("NUMBER", verification_number);
                    context.startActivity(mIntent);
                }
            }
        }
    }
}
