package edu.android20191112.testreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    IntentFilter filter;
    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
//        복수 개의 action을 등록할 수 있음
//        filter.addAction("edu.scsa.action.Connection_Fail");
        myReceiver = new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // BR 등록
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // BR 해지
        unregisterReceiver(myReceiver);
    }

//    익명의 내부 클래스 활용
//    BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            if(action.equals("edu~~.")){
//                ...
//            } else ...
//        }
//    }
}
