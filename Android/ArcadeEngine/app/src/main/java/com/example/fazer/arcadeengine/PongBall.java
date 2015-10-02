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
 */
public class PongBall {
    float x;
    float y;
    float xVel; //pixels per second
    float yVel;
    long prevTime;
    long startTime;
    static int radius;
    int hitTime;

    final int LOSE = 0;

    startSecondActivity StartSecondActivity = new startSecondActivity();

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PongBall() {
        x = 200;
        y = 200;
        radius = 20;
        xVel = 200;
        yVel = 200;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.GREEN);
        prevTime = System.currentTimeMillis();
        startTime = System.currentTimeMillis();
        //Log.d("StartTime: " , String.valueOf(startTime));
    }

    //Accessors
    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    //Modifiers
    public void setX(int xx) {
        x = xx;
    }

    public void setY(int yy) {
        y = yy;
    }

    public void setColor(int c) {
        paint.setColor(c);
    }

    //Methods

    /**
     * Draws a circle at point (x,y) with a radius of 'radius'
     *
     * @param c
     * @param radius
     */
    public void draw(Canvas c, int radius) {
        c.drawCircle(x, y, radius, paint);
    }

    /**
     * Updates the location of the PongBall based on time passed and velocity.
     *
     * @param x2 the x coordinate of the paddle
     * @param y2 the y coordinate of the paddle
     * @param c  the Canvas being drawn on.
     */
    public void animate(int x2, int y2, int xSide, int ySide, Canvas c) {

        //Log.d("X side PB", String.valueOf(xSide));
        //Log.d("Y side PB", String.valueOf(ySide));
        //outside coordinates of the paddle
        int Lx, By, Rx, Ty;
        Lx = x2 - xSide;
        Rx = x2 + xSide;

        Ty = y2 - ySide;
        By = y2 + ySide;

        /*
        Because the Android system is a bit irregular in its time sharing,
        we consider how much time has passed in animating objects to make the movement smoother.
         */
        long nowTime = System.currentTimeMillis();
        long mSecPassed = nowTime - prevTime;
        double dx = xVel * mSecPassed / 1000; //Change in x-position
        double dy = yVel * mSecPassed / 1000; //Change in y-position
        prevTime = nowTime;

        x += dx;
        //Bounce off walls
        if (x < radius) {
            x = radius;
            xVel = -xVel;
        }
        if (x > c.getWidth() - radius) {
            x = c.getWidth() - radius;
            xVel = -xVel;
        }

        y += dy;
        //Bounce off walls
        if (AnimatedSurface.running)
            if ((y - radius) > c.getHeight())
                StartSecondActivity.startSecondActivity(LOSE, startActivity.SCORE);
        if (y < radius) {
            y = radius;
            yVel = -yVel;
        }

        //int nowtime = (int) (System.currentTimeMillis() / 1000);
        if (x2 != 0 && y2 != 0) {
            //bounce off paddle
            if ((x + radius) >= Lx && (x - radius) <= Rx && (y + radius) >= Ty) { // is within paddle  NOT REACHING THIS!!!!!
                //hitTime = (int) (System.currentTimeMillis() / 1000);
                //Log.d("ball", "is within paddle");
                //SOMETHING NOT WORKING HERE!
                if (Math.abs(y + radius - y2) <= ySide) { //top
                    yVel = -yVel;
                    y = Ty - radius;
                } else if (Math.abs(y - radius - y2) <= ySide) { // bottom
                    yVel = -yVel;
                    y = By + radius;
                } else if (Math.abs(x + radius - x2) <= xSide) { //left
                    xVel = -xVel;
                    x = Lx - radius;
                } else if (Math.abs(x - radius - x2) <= xSide) { //right
                    xVel = -xVel;
                    x = Rx + radius;
                }
            }
        }
    }
}

