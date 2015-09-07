package com.example.cameraexample;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
	
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	
	private mediaFile saveFile = new mediaFile();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    protected void picture(){
    	Intent takeAPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	Uri location = saveFile.getOutputMediaUri(MEDIA_TYPE_IMAGE);
    	takeAPicture.putExtra(MediaStore.EXTRA_OUTPUT, location);
    	startActivityForResult(takeAPicture, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }
    
    protected void video(){
    	Intent takeAVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
    	Uri location = saveFile.getOutputMediaUri(MEDIA_TYPE_VIDEO);
    	takeAVideo.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
    	takeAVideo.putExtra(MediaStore.EXTRA_DURATION_LIMIT,10);
    	takeAVideo.putExtra(MediaStore.EXTRA_OUTPUT, location);
    	startActivityForResult(takeAVideo, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
    }
    
    @Override
    protected void onActivityResult(int RequestCode, int ResultCode, Intent file){
    	Intent saveDelete = new Intent(this, Activity2.class);
    	saveDelete.putExtras(file);
    	startActivity(saveDelete);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
