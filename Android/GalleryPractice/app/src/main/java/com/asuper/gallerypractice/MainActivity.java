package com.asuper.gallerypractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends BaseActivity {

    ImageView imageView;

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    Uri fileUri = null;
    public void onCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                File imagefile = newfile();
                fileUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID+".provider", imagefile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent, REQ_CAMERA);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            startActivityForResult(intent, REQ_CAMERA);
        }
    }

    private File newfile() throws IOException{

        String tempFileName = "Temp_" + System.currentTimeMillis();
        File tempDir = new File(Environment.getExternalStorageDirectory() + "/CameraN/");
        if(!tempDir.exists()) {
            tempDir.mkdirs();
        }
        File tempFile = File.createTempFile(
                tempFileName,
                ".png",
                tempDir
        );
        return tempFile;
    }

    private static final int REQ_CAMERA = 111;
    private static final int REQ_GALLERY = 222;

    public void onGallery(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQ_GALLERY);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Uri imageUri = null;
            switch (requestCode) {
                case REQ_GALLERY:
                    if(data != null) {
                        imageUri = data.getData();
                        imageView.setImageURI(imageUri);
                    }
                    break;
                case REQ_CAMERA:
                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        imageUri = data.getData();
                    } else {
                        imageUri = fileUri;
                    }
                    imageView.setImageURI(imageUri);
                    break;
            }
        }
    }
}
