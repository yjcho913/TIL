package edu.android20191111.testforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    Intent recIntent;
    EditText editTv;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTv = (EditText)findViewById(R.id.editTv);
        recIntent = getIntent();
        text = recIntent.getStringExtra("data");
        editTv.setText(text);
    }

    public void save(View view) {
        // 수정된 값을 꺼내서 인텐트에 담아 다시 main으로 전달
        recIntent.putExtra("rec_text", editTv.getText().toString());
        setResult(RESULT_OK, recIntent);
        finish();
    }

    public void cancel(View view) {
        // 작업 취소
        setResult(RESULT_CANCELED);
        finish();
    }
}
