package com.example.asuper.memopractice2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asuper.memopractice2.domain.Memo;
import com.example.asuper.memopractice2.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WriteActivity extends AppCompatActivity {

    private Button btnPost;
    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        revView();
        revListener();
    }


    private Memo getMemoFromScreen() {
        Memo memo = new Memo();
        memo.setNo(1);
        memo.setTitle(editTitle.getText().toString());
        memo.setAuthor(editAuthor.getText().toString());
        memo.setContent(editContent.getText().toString());
        memo.setDatetime(System.currentTimeMillis());
        return memo;
    }

    private void write(Memo memo) {
        try {
            String filename = System.currentTimeMillis() + ".txt";

            FileUtil.write(this, filename, memo.toString());
            setResult(RESULT_OK);

            Toast.makeText(this, "등록되었습니다!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "error"+e.toString(), Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void revListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Memo memo = getMemoFromScreen();
                write(memo);
            }
        });
    }

    private void revView() {
        btnPost = findViewById(R.id.btnPost);
        editTitle = findViewById(R.id.editTitle);
        editAuthor = findViewById(R.id.editAuthor);
        editContent = findViewById(R.id.editContent);
    }
}
