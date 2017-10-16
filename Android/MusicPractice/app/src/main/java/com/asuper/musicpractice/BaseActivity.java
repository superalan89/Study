package com.asuper.musicpractice;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super on 2017-10-13.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private static final int REQ_CODE = 777;

    private static final String permissions[] = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public abstract void init();

    @Override
    protected void onCreate(Bundle savedInstanceCurrent) {
        super.onCreate(savedInstanceCurrent);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        } else {
            init();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void checkPermission() {
        List<String> requires = new ArrayList();
        for(String permission : permissions){
            if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                requires.add(permission);
            }
        }
        if(requires.size() > 0) {
            String perms[] = requires.toArray(new String[requires.size()]);
            requestPermissions(perms, REQ_CODE);
        } else {
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQ_CODE){
            boolean granted = true;
            for(int grant : grantResults){
                if(grant != PackageManager.PERMISSION_GRANTED){
                    granted = false;
                    break;
                }
            }
            if(granted){
                init();
            }
        }
    }
}
