package edu.android20191113.testlayoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LayoutInflater layoutinf;
    LinearLayout myLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LayoutInflater 객체 초기화
        // LayoutInflater : Layout xml 파일을 객체로 변환
        layoutinf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        // 객체로 변환할 Layout 초기화
        myLinear = findViewById(R.id.myLinear);


    }

    public void showAtype(View view) {
        // 객체로 변환
        View aView = layoutinf.inflate(R.layout.a_layout, null);

        // 기존 Layout 제거
        myLinear.removeAllViews();

        // Layout에 추가
        myLinear.addView(aView);
    }

    public void showBtype(View view) {

        // B screen의 TextView에 원하는 문자열 표시
        // "오늘 점심은 마라탕"
        View bView = layoutinf.inflate(R.layout.b_layout, null);

        // 그냥 findViewById 하면, 현재 떠있는 R.layout.activity_main 에서 탐색
        // ---> bView에서 가져오게 수정해야 함
        TextView textV = bView.findViewById(R.id.titleTv);
        textV.setText("오늘 점심은 마라탕");

        myLinear.removeAllViews();
        myLinear.addView(bView);
    }
}
