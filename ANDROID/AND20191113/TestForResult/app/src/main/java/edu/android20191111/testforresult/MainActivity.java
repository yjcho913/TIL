package edu.android20191111.testforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView infoTv;
    public static final int EDIT_MODE = 1;
    public static final int SEARCH_MODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoTv = (TextView)findViewById(R.id.infoTv);
    }

    public void edit(View view) {
        // 호출시 묵시적인 방법을 이용하여 호출 : com.android20191111.action.EDIT
        Intent i = new Intent("edu.android20191111.action.EDIT");
        i.putExtra("data", infoTv.getText().toString());
        startActivityForResult(i, EDIT_MODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            infoTv.setText(data.getStringExtra("rec_text"));
        }
    }
}
