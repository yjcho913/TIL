package edu.android20191112.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    이벤트 구현 방법
    1. Event Source, Event Type 정하기
    2. Event Handler 구현 (this / nested / annonymous nested)
    3. Event Source에 Event Handler 등록
    */

    Button thisB, nestB, annoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisB = findViewById(R.id.thisbut);
        nestB = findViewById(R.id.nestbut);
        annoB = findViewById(R.id.annobut);

        thisB.setOnClickListener(this);
        nestB.setOnClickListener(new MyClickHandler());

        annoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "anno nested로 구현...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "nested로 구현...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "this로 구현...", Toast.LENGTH_SHORT).show();
    }
}
