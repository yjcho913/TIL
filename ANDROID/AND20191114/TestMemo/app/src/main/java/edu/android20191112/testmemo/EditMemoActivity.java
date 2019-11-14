package edu.android20191112.testmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditMemoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText titleEt, contentEt, dateEt;
    Button okBut, cancelBut;
    Intent recIntent;
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_memo);

        recIntent = getIntent();
        mode = recIntent.getIntExtra("mode", 0);
        okBut = findViewById(R.id.okBut);
        cancelBut = findViewById(R.id.cancelBut);
        titleEt = findViewById(R.id.titleEt);
        contentEt = findViewById(R.id.contentEt);
        dateEt = findViewById(R.id.dateEt);

        switch(mode){
            case MainActivity.ADD_MODE:
                titleEt.setEnabled(true);
                titleEt.requestFocus();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                dateEt.setText(dateFormat.format(cal.getTime()).toString());
                break;
            case MainActivity.EDIT_MODE:
                titleEt.setEnabled(false);
                titleEt.setText(recIntent.getStringExtra("title"));
                contentEt.setText(recIntent.getStringExtra("content"));
                dateEt.setText(recIntent.getStringExtra("date"));
                contentEt.requestFocus();
                break;
        }

        okBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.cancelBut){
            setResult(RESULT_CANCELED, recIntent);
        }
        else{
            recIntent.putExtra("title", titleEt.getText().toString());
            recIntent.putExtra("content", contentEt.getText().toString());
            recIntent.putExtra("date", dateEt.getText().toString());
            setResult(RESULT_OK, recIntent);
        }
        finish();
    }
}
