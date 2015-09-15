package com.example.fazer.arcadeengine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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
    int radius;

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
    }

    //Accessors
    public int getX() { return (int)x; }
    public int getY() { return (int)x; }

    //Modifiers
    public void setX(int xx) { x = xx; }
    public void setY(int yy) { y = yy; }
    public void setColor(int c) { paint.setColor(c); }

    //Methods
    public void draw(Canvas c)
    {
        c.drawCircle((float) x, (float) y, radius, paint);
    }

    public void drawRect(Canvas c){
        c.drawRect((float) x - 10,(float) x + 10, (float) y - 10,(float) y + 10, paint);
    }

    /**
     * Updates the location of the PongBall based on time passed and velocity.
     * @param c the Canvas being drawn on.
     */
    public void animate(int x2, int y2, Canvas c)
    {
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
        //bounce off paddle
        if(x<)
        y+=dy;
        //Bounce off walls
        if(y<radius) { y=radius; yVel=-yVel; }
        if(y>c.getHeight()-radius) { y=c.getHeight()-radius; yVel=-yVel; }
        //bounce off paddle


    }

}
