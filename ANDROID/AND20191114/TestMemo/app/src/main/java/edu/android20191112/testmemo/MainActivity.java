package edu.android20191112.testmemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity<onActivityResult> extends AppCompatActivity {

    public static final int ADD_MODE = 1;
    public static final int EDIT_MODE = 2;
    private static final int ADD_ID = Menu.FIRST;
    private static final int APPINFO_ID = Menu.FIRST + 1;

    ListView titleLv;
    ArrayList<Memo> memoList;
    MemoManager memoManager;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoManager = MemoManager.getInstance();
        titleLv = findViewById(R.id.titleLv);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String dialogMsg = "packageName : " + this.getApplicationInfo().packageName +
                "\ntargetSdkVersion : " + this.getApplicationInfo().targetSdkVersion +
                "\nminSdkVersion : " + this.getApplicationInfo().minSdkVersion;
        builder.setMessage(dialogMsg)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        alert = builder.create();


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
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, ADD_ID, 0, R.string.addMemo)
                .setIcon(android.R.drawable.ic_menu_add)
                .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, APPINFO_ID, 0, R.string.appInfo);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case ADD_ID:
                Intent i = new Intent(MainActivity.this, EditMemoActivity.class);
                i.putExtra("mode", ADD_MODE);
                startActivityForResult(i, ADD_MODE);
                break;
            case APPINFO_ID:
                alert.show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
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
