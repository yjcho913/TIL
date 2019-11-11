package edu.android20191111.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A1_Activity extends AppCompatActivity {

    TextView infoTv;

    @Override
    // 생성자 함수와 같은 역할
    // 주로 초기화가 이루어짐
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_);
        infoTv = findViewById(R.id.infoTv );

        Intent recIntent = getIntent();
        String path = recIntent.getStringExtra("path");
        infoTv.setText("받은 데이터 : "+ path);
    }

    public void main_call(View view) {
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
        // mainactivity로 되돌아가기
        finish();
    }
}
