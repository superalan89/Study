package net.flow9.realm;

import android.app.Application;

import io.realm.Realm;

public class RealmApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
