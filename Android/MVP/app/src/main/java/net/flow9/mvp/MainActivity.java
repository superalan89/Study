package net.flow9.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.flow9.mvp.contract.MainContract;
import net.flow9.mvp.presenter.MainPresenter;
import net.flow9.mvp.view.MainView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        // 1. 뷰 생성
        MainContract.IView mainView = new MainView(this);
        setContentView(mainView.getView());

        // 2. 프레젠터 생성
        MainContract.IPresenter presenter = new MainPresenter();
        presenter.attachView(mainView);
    }
}
