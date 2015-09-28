package com.example.balanagav.cameraexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.io.File;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
import static android.provider.MediaStore.EXTRA_OUTPUT;

public class MainActivity extends Activity {

    private mediaFile mediafile = new mediaFile();

    private final int IMAGE_REQUEST_CODE = 100;
    private final int VIDEO_REQUEST_CODE = 200;

    private final int MEDIA_TYPE_IMAGE = 1;
    private final int MEDIA_TYPE_VIDEO = 2;

    Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button picture = (Button) findViewById(R.id.takeAPicture);
        picture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                picture();
            }
        });

        final Button video = (Button) findViewById(R.id.takeAVideo);
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                video();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void picture() {
        Intent takeAPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = mediafile.getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        takeAPicture.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(takeAPicture, IMAGE_REQUEST_CODE);
    }

    protected void video() {
        Intent takeAVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        file = mediafile.getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
        takeAVideo.putExtra(MediaStore.EXTRA_OUTPUT, file);
        takeAVideo.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);
        takeAVideo.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(takeAVideo, VIDEO_REQUEST_CODE);
    }


}
