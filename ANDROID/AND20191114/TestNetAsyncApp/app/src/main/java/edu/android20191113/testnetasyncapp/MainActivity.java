package edu.android20191113.testnetasyncapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText urlEt;
    TextView displayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEt = findViewById(R.id.urlEt);
        displayTv = findViewById(R.id.displayTv);
    }

    public void search(View view) {
        String url = urlEt.getText().toString();
        new DataDownTask().execute(url);
        Toast.makeText(this, url + " SEARCH START...", Toast.LENGTH_SHORT).show();
    }

    class DataDownTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... args) {
            String str = null;
            StringBuilder sb = new StringBuilder();

            try {
                URL myUrl = new URL(args[0]);
                HttpURLConnection httpUrlCon = (HttpURLConnection) myUrl.openConnection();
                InputStream is = httpUrlCon.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));

                while((str = in.readLine())!=null){
//                    publishProgress(str);
                    sb.append(str);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            displayTv.append(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            displayTv.setText(s);
        }
    }
}
