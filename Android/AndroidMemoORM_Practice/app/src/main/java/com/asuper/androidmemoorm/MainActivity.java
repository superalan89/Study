package com.asuper.androidmemoorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.asuper.androidmemoorm.dao.PicNoteDAO;
import com.asuper.androidmemoorm.model.PicNote;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void openDraw(View view){
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }

    private void init(){
        PicNoteDAO dao = new PicNoteDAO(this);

        List<PicNote> data = dao.readAll();

        CustomAdapter adapter = new CustomAdapter();
        adapter.setData(data);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}