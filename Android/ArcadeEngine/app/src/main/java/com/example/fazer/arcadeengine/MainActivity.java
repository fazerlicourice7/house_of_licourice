package com.example.fazer.arcadeengine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by spockm on 6/25/2014.
 */
public class MainActivity extends Activity {

    AnimatedSurface mySurfaceView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySurfaceView = new AnimatedSurface(this);
        setContentView(mySurfaceView);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mySurfaceView.onResumeMySurfaceView();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mySurfaceView.onPauseMySurfaceView();
    }

//    public boolean onTouchEvent(MotionEvent event)
//    {
//        //THIS METHOD NEVER RUNS...
//        Toast.makeText(this, "Something", Toast.LENGTH_SHORT).show();
//
//        if(event.getX() < 100)
//        {
//            Toast.makeText(this, "CornerEvent", Toast.LENGTH_SHORT).show();
//
////            startSecondActivity();
//        }
//        return true;
//    }
//
//
//    public void startSecondActivity()
//    {
//        startActivity(new Intent(MainActivity.this, SecondActivity.class));
//    }

}
