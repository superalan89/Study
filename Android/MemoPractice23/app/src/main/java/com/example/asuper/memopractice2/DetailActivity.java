package com.example.asuper.memopractice2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.asuper.memopractice2.domain.Memo;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtDate;
    private TextView txtAuthor;
    private TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        revView();
        rev();
    }

    private void rev() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1 );

        Memo memo = ListAdapter.data.get(position);

        txtTitle.setText(memo.getTitle());
        txtDate.setText(memo.getDatetime()+"");
        txtAuthor.setText(memo.getAuthor());
        txtContent.setText(memo.getContent());

    }

    private void revView() {
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtContent = findViewById(R.id.txtContent);
    }
}
