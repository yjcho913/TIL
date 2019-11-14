package edu.android20191113.testthread;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TestAsyncTaskActivity extends AppCompatActivity {

    TextView mainTv, backTv;
    int mainNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTv = findViewById(R.id.mainTv);
        backTv = findViewById(R.id.backTv);
        new MyCountAsyncTest().execute(15);
    }


    public void addNum(View view) {
        // 버튼 클릭시 +1씩 증가시켜 값을 mainTv에 반영
        mainTv.setText("MAIN : " + (++mainNum));
    }

    class MyCountAsyncTest extends AsyncTask<Integer, Integer, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // 필수!
        @Override
        protected Integer doInBackground(Integer... args) {
            Log.i("INFO", "doInBackground : " + Thread.currentThread().getName());
            for(int i=0; i <= args[0]; i++){
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return args[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i("INFO", "onProgressUpdate : " + Thread.currentThread().getName());
            super.onProgressUpdate(values);
            backTv.setText("BACK : " + values[0]);
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            Toast.makeText(TestAsyncTaskActivity.this, result + "초가 지났습니다!", Toast.LENGTH_SHORT).show();
        }
    }
}
