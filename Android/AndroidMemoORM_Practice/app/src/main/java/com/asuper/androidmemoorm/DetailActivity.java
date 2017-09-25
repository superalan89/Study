package com.asuper.androidmemoorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.asuper.androidmemoorm.domain.Memo;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDate;
    private TextView textAuthor;
    private FrameLayout stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        init();
    }

    public void init(){
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

//        String title = intent.getStringExtra("title");
//        String author = intent.getStringExtra("author");
//        String content = intent.getStringExtra("content");
//        String datetime = intent.getStringExtra("datetime");
        Memo memo = ListAdapter.data.get(position);

        textTitle.setText(memo.getTitle());
        textDate.setText(memo.getDatetime()+"");
        textAuthor.setText(memo.getAuthor());

    }

    private void initView() {
        textTitle = (TextView) findViewById(R.id.textTitle);
        textDate = (TextView) findViewById(R.id.textDate);
        textAuthor = (TextView) findViewById(R.id.textAuthor);

}
}
