package com.example.asuper.firebasemessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // 파이어베이스 인증
    private FirebaseAuth mAuth;

    // 데이터 베이스
    private FirebaseDatabase database;
    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("user");
    }
}
