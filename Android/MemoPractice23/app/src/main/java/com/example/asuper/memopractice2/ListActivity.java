package com.example.asuper.memopractice2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asuper.memopractice2.domain.Memo;
import com.example.asuper.memopractice2.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        revView();
        revListener();
        rev();
    }

    private void rev() {
        Log.d("ListActivity", "called rev()");
        ArrayList<Memo> list = loadList();
        ListAdapter adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private ArrayList<Memo> loadList() {
        ArrayList<Memo> result = new ArrayList<>();
        for(File item : getFilesDir().listFiles()) {
            try {
                String text = FileUtil.read(this, item.getName());
                Memo memo = new Memo(text);
                result.add(memo);
            } catch (IOException e) {
                Toast.makeText(this, "에러가 났습니다."+e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        return result;
    }

    private  static final int WRITE_ACTIVITY = 12345;

    private void revListener() {
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, WriteActivity.class);
                startActivityForResult(intent, WRITE_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case WRITE_ACTIVITY:
                if(resultCode == RESULT_OK) {
                    rev();
                }
                break;
        }
    }


    private void revView() {
        listView = (ListView) findViewById(R.id.listView);
        btnWrite = (Button) findViewById(R.id.btnWrite);
    }
}
