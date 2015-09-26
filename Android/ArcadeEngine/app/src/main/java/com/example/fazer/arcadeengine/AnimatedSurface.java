package com.example.fazer.arcadeengine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by spockm on 8/11/2015.
 */
public class AnimatedSurface extends SurfaceView implements Runnable
{
    //Instance variables
    private PongBall ball = new PongBall(); //This is the green PongBall that moves around.
    private PongBall touchTrackerPaddle;          //This is the blue Paddle that tracks touches.
    private Random random = new Random();

    Paint sharedPaint = new Paint(Paint.ANTI_ALIAS_FLAG); //A shared paint object
    Thread thread = null;
    static Context context;
    SurfaceHolder surfaceHolder;
    static volatile boolean running = false;

    startSecondActivity StartSecondActivity = new startSecondActivity();
    int Cx = 100, Cy = 100, Cr = 60;

    boolean firstTime = true;

    //constants
    final int WIN = 1;

    /**
     * CONSTRUCTOR -
     * @param context
     */
    public AnimatedSurface(Context context) {
        super(context);
        this.context = context;
        // TODO Auto-generated constructor stub
        surfaceHolder = getHolder();
    }

    /**
     * This method (re)starts the animation Thread when this Surface resumes.
     */
    public void onResumeMySurfaceView(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * This method stops the Thread when paused.
     */
    public void onPauseMySurfaceView(){
        boolean retry = true;
        running = false;
        while(retry){
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    /**
     * This is required to implement Runnable.  It is overwriting the version of this method
     * that was inherited from SurfaceView.
     * THIS METHOD IS ANALOGOUS TO THE renderFrame() METHOD IN THE ARCADE ENGINE.
     */
    public void run() {
        // TODO Auto-generated method stub
        while(running){
            if(surfaceHolder.getSurface().isValid()){
                Canvas canvas = surfaceHolder.lockCanvas();
                /**
                 * =====================================================================
                 * This is where the actual drawing on the canvas takes place.
                 * Think of this section as the same as the renderFrame() method
                 * from the old ArcadeEngine.  The Canvas is analogous to a Graphics object.
                 * =====================================================================
                 */
                //Drawing stationary objects.
                clearScreen(canvas);
                //firstTime = false;
                //drawBorder(canvas);
                drawCircle(canvas);
                drawText(canvas);
//              drawRandomRectangles(canvas); //often commented out because it is annoying!
                drawImage(canvas);
                //location of paddle
                int x2 = 0, y2 = 0;
                if(touchTrackerPaddle != null) {
                    x2 = touchTrackerPaddle.getX();
                    y2 = touchTrackerPaddle.getY();
                }
                //Animating and drawing movable objects.
                ball.animate(x2, y2, canvas);
                ball.draw(canvas);
                if(touchTrackerPaddle != null) //No tracker paddle  appears until first touch.
                    touchTrackerPaddle.drawRect(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            //if second activity is not running
            //If the user gets the pong ball in the circle, start a new Activity
            if(!WINorLOSE.donePlaying) {
                if (inCircle(ball.getX(), ball.getY())) {
                    //ball.setX();
                    //ball.setY();
                    StartSecondActivity.startSecondActivity(WIN);
                    ((Activity)getContext()).finish();
                }
            }
        }
    }

    public void clearScreen(Canvas c)
    {
        int RED = 0, GREEN = 0, BLUE = 0;
        if(firstTime) {
            //This fills the screen with a random color (r,g,b).
            Random redR = new Random();
            Random greenR = new Random();
            Random blueR = new Random();
            RED = redR.nextInt(255);
            GREEN = greenR.nextInt(255);
            BLUE = blueR.nextInt(255);
            firstTime = false;
        }
            c.drawRGB(RED, GREEN, BLUE);
    }

    public void drawBorder(Canvas c)
    {
        sharedPaint.setStyle(Paint.Style.STROKE);
        sharedPaint.setStrokeWidth(5);
        sharedPaint.setColor(Color.RED);
        c.drawRect(0, 0, c.getWidth(), c.getHeight(), sharedPaint);
    }

    /**
     * This method provides an example for drawing text to the screen.
     * There are many other methods in the Paint class to learn about.
     * (Only a few are demonstrated here.)
     * @param c the Canvas being drawn on.
     */
    public void drawText(Canvas c)
    {
        Paint pen = new Paint(Paint.LINEAR_TEXT_FLAG);
        pen.setStyle(Paint.Style.STROKE);
        pen.setStrokeWidth(2);
        pen.setColor(Color.BLACK);
        pen.setTypeface(Typeface.SANS_SERIF);
        pen.setTextSize(60);

        c.drawText("Get the Green ball into the circle!", 200, 200, pen);
    }

    /**
     * Draws an Image to the screen.
     * The Image must be in the res/drawable folder.
     *
     * @param c the Canvas being drawn on.
     */
    public void drawImage(Canvas c)
    {
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.android_image);
        c.drawBitmap(image, 200, 220, sharedPaint);
    }

    /*
    public void drawRandomRectangles(Canvas c)
    {
        //Choose a random size
        int w = c.getWidth();
        int h = c.getHeight();
        int x = random.nextInt(w - 1);
        int y = random.nextInt(h - 1);
        //Choose a random Color
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        Paint special = new Paint();
        special.setColor(0xff000000 + (r << 16) + (g << 8) + b);
        //Draw it!
        c.drawRect(x, y, x+40, y+40, special);
    }
    */

    public void drawCircle(Canvas c) {
            sharedPaint.setStyle(Paint.Style.STROKE);
            sharedPaint.setStrokeWidth(1);
            sharedPaint.setColor(Color.WHITE);
            c.drawCircle(Cx, Cy, Cr, sharedPaint);
    }

    /**
     * Whenever the screen is touched this method will be called.
     * This is very similar to the MouseEvents and KeyboardEvents from the ArcadeEngine.
     * @param event The MotionEvent object contains details of the touchEvent.
     * @return - currently always returns true.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //Construct the PongBall on the first touch of the screen.
        if (touchTrackerPaddle == null)
        {
            touchTrackerPaddle = new PongBall();
            touchTrackerPaddle.setColor(Color.BLUE);
        }

        //Update the location of the touchTrackerPaddle
        touchTrackerPaddle.setX((int) event.getX());
        touchTrackerPaddle.setY((int) event.getY());
        return true;
    }

    /**
     * A method to determine if a point (x,y) is in a circle.
     * The circle being checked is centered at Cx,Cy with radius Cr
     * (The circle from the drawCircle method in this demo.)
     * @param x
     * @param y
     * @return true if (x,y) is contained in the circle.
     */
    public boolean inCircle(int x, int y) {
        int radius = PongBall.radius;
        if (Math.abs(Cx - (x + radius)) < Cr && Math.abs(Cy - (y + radius)) < Cr)
            return true;
        return false;
    }

}
