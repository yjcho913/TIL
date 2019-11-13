package edu.android20191112.testmemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity<onActivityResult> extends AppCompatActivity {

    public static final int ADD_MODE = 1;
    public static final int EDIT_MODE = 2;

    Button addBut;
    ListView titleLv;
    ArrayList<Memo> memoList;

    MemoManager memoManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoManager = MemoManager.getInstance();
        addBut = findViewById(R.id.addBut);
        titleLv = findViewById(R.id.titleLv);


        addBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditMemoActivity.class);
                i.putExtra("mode", ADD_MODE);
                startActivityForResult(i, ADD_MODE);
            }
        });

        titleLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, EditMemoActivity.class);
                Memo memo = memoManager.getAllMemo().get(position);
                i.putExtra("title", memo.getTitle());
                i.putExtra("content", memo.getContent());
                i.putExtra("date", memo.getDate());
                i.putExtra("mode", EDIT_MODE);
                startActivityForResult(i, EDIT_MODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            String date = data.getStringExtra("date");

            Memo memo = new Memo(title, content, date);
            switch(requestCode){
                case ADD_MODE:
                    memoManager.addMemo(memo);
                    break;
                case EDIT_MODE:
                    memoManager.updateMemo(title, memo);
                    break;
            }

        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        memoList = memoManager.getAllMemo();

        final ArrayAdapter<Memo> memoAdapter = new ArrayAdapter<Memo>(this, android.R.layout.simple_list_item_1, memoList);
        titleLv.setAdapter(memoAdapter);
    }
}
