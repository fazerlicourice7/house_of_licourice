package com.example.fazer.arcadeengine;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by fazer on 9/28/15.
 */
public class paddle {

    int x;
    int y;

    private Paint paint;

    public paddle(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
    }


    /**
     * Draws a rectangle with the specified outer dimensions.
     * @param c
     * @param width
     * @param length
     */
    public void drawRect(Canvas c, int width, int length) {
        //params : left, top, right, bottom
        c.drawRect(x - (width / 2), y + (length / 2), x + (width / 2), y - (length / 2), paint);
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

}
