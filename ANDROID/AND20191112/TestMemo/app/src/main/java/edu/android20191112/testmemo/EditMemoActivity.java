package edu.android20191112.testmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditMemoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText titleEt, contentEt, dateEt;
    Button okBut, cancelBut;
    Intent recIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_memo);

        okBut = findViewById(R.id.okBut);
        cancelBut = findViewById(R.id.cancelBut);
        titleEt = findViewById(R.id.titleEt);
        contentEt = findViewById(R.id.contentEt);
        dateEt = findViewById(R.id.dateEt);
        recIntent = getIntent();

        okBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.okBut:
                MemoManager.getInstance().addMemo(new Memo(titleEt.getText().toString(), contentEt.getText().toString(), dateEt.getText().toString()));
                setResult(RESULT_OK, recIntent);
                break;
            case R.id.cancelBut:
                break;
        }
        finish();
    }
}
