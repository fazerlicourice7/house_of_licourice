package com.example.fazer.camera_example;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.Override;

public class MainActivity extends Activity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;

    private static final int MEDIA_TYPE_IMAGE = 1;
    private static final int MEDIA_TYPE_VIDEO = 2;

    private mediaFile savefile = new mediaFile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void picture(){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri location = savefile.getOutputMediaUri(MEDIA_TYPE_IMAGE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, location);
        startActivityForResult(camera, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private void video(){
        Intent camera = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        Uri location = savefile.getOutputMediaUri(MEDIA_TYPE_IMAGE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, location);
        camera.putExtra(MediaStore.EXTRA_DURATION_LIMIT,10);
        camera.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(camera, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent file){
        Intent saveDelete = new Intent(this, SaveDelete.class);
        saveDelete.putExtras(file);
        startActivity(saveDelete);
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
}
