package net.flow9.mvp.presenter;

import net.flow9.mvp.contract.MainContract;
import net.flow9.mvp.contract.MainContract.*;

/**
 * Created by pc on 23/11/2017.
 */

public class MainPresenter implements MainContract.IPresenter{
    IView view;
    public MainPresenter() {

    }
    @Override
    public void attachView(IView view) {
        this.view = view;
    }

    public void task1(){
        view.setTextView("Clicked!");
    }
}
