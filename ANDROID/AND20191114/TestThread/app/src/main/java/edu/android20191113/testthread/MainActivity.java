package edu.android20191113.testthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addNumBut;
    TextView mainTv, backTv;
    int mainNum;
    int backNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNumBut = findViewById(R.id.addNumBut);
        mainTv = findViewById(R.id.mainTv);
        backTv = findViewById(R.id.backTv);

        new MyNetworkThread().start();
    }

    public void addNum(View view) {
        // 버튼 클릭시 +1씩 증가시켜 값을 mainTv에 반영
        mainTv.setText("MAIN : " + (++mainNum));
    }


    // ui 를 만든 스레드만이 ui에 접근 가능하다!
    class MyNetworkThread extends Thread {
        // 1부터 10까지 1초마다 +1씩 증가시키면서 해당 값을 backTv에 반영

        @Override
        public void run() {
            super.run();
            for(int i=0; i<=10; i++){
                final String sendData = "BACK : " + (backNum++);


                // ************* msg와 sendMessage 활용
//                Message msg = myHandler.obtainMessage(1, sendData);
//                myHandler.sendMessage(msg);



                // ************* Runnable과 post 활용
//                // 이 작업은 main이 수행!
//                myHandler.post(new Runnable(){
//
//                    @Override
//                    public void run() {
//                        Log.i("INFO", "run : " + Thread.currentThread().getName());
//                        backTv.setText(sendData);
//                    }
//                });


                // *********** 위의 Runnable, post와 동일
                runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        backTv.setText(sendData);
                    }
                });


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Handler myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                backTv.setText(msg.obj.toString());
            }
        };
    }
}
