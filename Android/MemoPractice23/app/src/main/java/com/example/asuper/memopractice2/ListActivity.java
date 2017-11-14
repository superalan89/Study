package com.example.asuper.memopractice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.example.asuper.memopractice2.domain.Memo;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        revView();
        revListener();
        rev();
    }

    private void rev() {
        Log.d("ListActivity", "called init()");
        ArrayList<Memo> list = loadList();
        ListAdapter adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private ArrayList<Memo> loadList() {
        ArrayList<Memo>
    }

    private void revView() {
        listView = (ListView) findViewById(R.id.listView);
        btnWrite = (Button) findViewById(R.id.btnWrite);
    }
}
