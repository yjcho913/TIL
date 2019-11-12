package edu.android20191112.testmemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity<onActivityResult> extends AppCompatActivity {

    public static final int ADD_MODE = 1;
    Button addBut;
    TextView titleTv1, titleTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBut = findViewById(R.id.addBut);
        titleTv1 = findViewById(R.id.titleTv1);
        titleTv2 = findViewById(R.id.titleTv2);

        setTextViewContent();

        addBut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditMemoActivity.class);
                startActivityForResult(i, ADD_MODE);
            }
        });
    }

    public void setTextViewContent(){
        MemoManager memoManager = MemoManager.getInstance();
        ArrayList<Memo> memolist = memoManager.getAllMemo();
        int len = memolist.size();

        if(len >= 1){
            titleTv1.setText(memolist.get(memolist.size()-1).getTitle());
            if(len >= 2){
                titleTv2.setText(memolist.get(memolist.size()-2).getTitle());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) setTextViewContent();
    }
}
