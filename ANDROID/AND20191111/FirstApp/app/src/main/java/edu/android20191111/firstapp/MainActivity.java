package edu.android20191111.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void a1Call(View view) {
        Toast.makeText(this, "A1 CALL...", Toast.LENGTH_SHORT).show();

        // 1. 같은 프로세스(같은 앱)에서 다른 컴포넌트 호출 (명시적 호출)
        Intent i = new Intent(this, A1_Activity.class);
        i.putExtra("path", "mySDcard/myData.dat");
        startActivity(i);


    }

    public void a2Call(View view) {
        // 2. 다른 프로세스(다른 앱)에 존재하는 컴포넌트 호출 (★★★묵시적 호출)
        Intent i2 = new Intent("com.android20191111.action.EDIT");
        startActivity(i2);
    }

    public void a3Call(View view) {
        // 3. 이미 정해져있는 액션 호출 (묵시적 호출)
        Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
        startActivity(i3);

        Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));
        startActivity(i4);

        Intent i5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(i5);

        Intent i6 = new Intent(Intent.ACTION_PICK);
        i6.setType("image/*");
        startActivity(i6);

    }
}
