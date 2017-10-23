package com.asuper.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@EActivity (R.layout.activity_main)
@WindowFeature(Window.FEATURE_NO_TITLE)
public class MainActivity extends AppCompatActivity{

    @ViewById
    TextView text;

    @AfterViews
    public void init() {
        text.setText("Hello AA");
    }

    @Background
    public void run() {
        // 여기는 sub thread에서 실행된다.
        for (int i=0; i<10; i++) {
            main(i);
        }
    }

    @Background
    public void main(int i) {
        // 여기 코드는 main thread 실행된다
        text.setText(i+"");
    }

}
