package com.example.fazer.arcadeengine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by spockm on 8/11/2015.
 * The PongBall is centered at x,y with radius.
 *
 */
public class PongBall
{
    double x;
    double y;
    double xVel; //pixels per second
    double yVel;
    long prevTime;
    long startTime;
    static int radius;

    final int LOSE = 0;

    startSecondActivity StartSecondActivity = new startSecondActivity();

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PongBall()
    {
        x=200;
        y=200;
        radius = 20;
        xVel = 150;
        yVel = 150;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.GREEN);
        prevTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();
        //Log.d("StartTime: " , String.valueOf(startTime));
    }

    //Accessors
    public int getX() { return (int)x; }
    public int getY() { return (int)x; }

    //Modifiers
    public void setX(int xx) { x = xx; }
    public void setY(int yy) { y = yy; }
    public void setColor(int c) { paint.setColor(c); }

    //Methods
    public void draw(Canvas c, int radius)
    {
        c.drawCircle((float) x, (float) y, radius, paint);
    }

    public void drawRect(Canvas c, int width, int length){
        //params : left, top, right, bottom
        c.drawRect((float) (x - (width / 2)), (float) (y + (length / 2)), (float) (x + (width / 2)), (float) (y - (length / 2)), paint);
    }

    /**
     * Updates the location of the PongBall based on time passed and velocity.
     * @param x2 the x coordinate of the paddle
     * @param y2 the y coordinate of the paddle
     * @param c the Canvas being drawn on.
     */
    public void animate(int x2, int y2, Canvas c)
    {

        //outside coordinates of the paddle
        int Lx, By, Rx, Ty;
        Lx = x2 - 30;
        Rx = x2 + 30;

        Ty = y2 - 30;
        By = y2 + 30;

        /*
        Because the Android system is a bit irregular in its time sharing,
        we consider how much time has passed in animating objects to make the movement smoother.
         */
        long nowTime = System.currentTimeMillis();
        long mSecPassed = nowTime-prevTime;
        double dx = xVel*mSecPassed/1000; //Change in x-position
        double dy = yVel*mSecPassed/1000; //Change in y-position
        prevTime = nowTime;

        x+=dx;
        //Bounce off walls
        if(x<radius) { x=radius; xVel=-xVel; }
        if(x>c.getWidth()-radius) { x=c.getWidth()-radius; xVel=-xVel; }

        y+=dy;
        //Bounce off walls
        if(y<radius) { y=radius; yVel=-yVel; }
        if(y>c.getHeight()-radius) {
            if(!WINorLOSE.donePlaying)
                StartSecondActivity.startSecondActivity(LOSE, startActivity.SCORE);
                y = c.getWidth() / 2;
                x = c.getHeight() / 2;
        }

        if(x2 != 0 && y2 != 0) {
            //Log.d("paddle location", String.valueOf(x2) + "," + String.valueOf(y2));
            //bounce off paddle
            if ((x + radius) >= Lx && (x - radius) <= Rx && (y + radius) >= Ty && (y - radius) <= By) { // is within paddle
                Log.d("ball", "is within paddle");
                if (Math.abs((x + radius) - x2) >= 29) {
                    if (x - x2 > 0) {
                        Log.d("Position", "right");
                        x = Rx + radius;
                    } else if (x - x2 < 0) {
                        Log.d("Position", "left");
                        x = Lx - radius;
                    }else
                        Log.d("Position", "In the center");
                    xVel = -xVel;
                  /*if (xVel > 0)
                        xVel++;
                    else
                        xVel--;  */
                }
                if (Math.abs((y + radius) - y2) >= 29) {
                    if (y - y2 > 0) {
                        Log.d("Position", "bottom");
                        y = By + radius;
                    } else if (y - y2 < 0) {
                        Log.d("Position", "top");
                        y = Ty - radius;
                    }else
                        Log.d("Position", "In the center");

                    yVel = -yVel;

                   /*if (yVel > 0)
                        yVel++;
                    else
                        yVel--; */
                }
            }
        }
    }
}
