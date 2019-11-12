package edu.android20191112.testreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // BroadcastReceiver는 context와 상속관계가 아님! ---> 'this'를 쓰면 안됨!
        Toast.makeText(context, "on Receive CALL ...", Toast.LENGTH_SHORT).show();

        Bundle myB = intent.getExtras();
        Object[] objArr = (Object[])myB.get("pdus");
        SmsMessage[] smsArr = new SmsMessage[objArr.length];
        smsArr[0] = SmsMessage.createFromPdu((byte[])objArr[0]);

        String telNum = smsArr[0].getOriginatingAddress();
        String msg = smsArr[0].getMessageBody();

        Toast.makeText(context,"phoneNum : " + telNum + "\n" + msg, Toast.LENGTH_SHORT).show();
    }
}
