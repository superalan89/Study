package net.flow9.mvp.contract;

import android.view.View;

/**
 * Created by pc on 23/11/2017.
 */

public interface MainContract {
    public interface IPresenter {
        public void attachView(IView view);
        public void task1();
    }

    public interface IView {
        public void setPresenter(IPresenter preseter);
        public void setTextView(String string);
        public View getView();
    }
}
