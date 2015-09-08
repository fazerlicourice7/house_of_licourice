package com.example.fazer.camera_example;

import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SaveDelete extends Activity {
    Intent media;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        media = getIntent();
    }

    protected void save() {

    }

    protected void delete() {
        Uri location = media.getData();
        File Location = new File(location.getPath());
        Location.delete();
    }
}