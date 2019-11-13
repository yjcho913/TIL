package edu.android20191113.myapplication;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends ListActivity {

    ListView myListV;
    String [] foodArr = {"마라탕", "탕수육", "초밥", "양꼬치", "떡볶이"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        setContentView(R.layout.activity_main);

        // 1. 사용할 ListView 객체 선언 및 초기화
        myListV = findViewById(R.id.myListV);

        // 2. AdapterView에 설정할 Adapter 선언 및 초기화
//        ArrayAdapter<String> foodA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodArr);
        final ArrayAdapter<String> foodA = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.titleTv, foodArr);

        // 3. AdapterView에 Adapter 설정
        myListV.setAdapter(foodA);


        // 4. 이벤트 구현
        myListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selItem = (String)parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this, selItem+"이(가) 선택되었습니다!", Toast.LENGTH_SHORT).show();
            }
        });
        */


        // 2. AdapterView에 설정할 Adapter 선언 및 초기화
        ArrayAdapter<String> foodA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodArr);
//        final ArrayAdapter<String> foodA = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.titleTv, foodArr);

        // 3. AdapterView에 Adapter 설정
        setListAdapter(foodA);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String selItem = (String)l.getAdapter().getItem(position);
        Toast.makeText(MainActivity.this, selItem+"이(가) 선택되었습니다!", Toast.LENGTH_SHORT).show();
    }
}
