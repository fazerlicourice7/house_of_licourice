package androidarcadeengine.aae2;

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
    private PongBall touchTrackerBall;          //This is the blue PongBall that tracks touches.
    private Random random = new Random();

    Paint sharedPaint = new Paint(Paint.ANTI_ALIAS_FLAG); //A shared paint object
    Thread thread = null;
    Context context;
    SurfaceHolder surfaceHolder;
    volatile boolean running = false;


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
                drawBorder(canvas);
                drawCircle(canvas);
                drawText(canvas);
//                drawRandomRectangles(canvas); //often commented out because it is annoying!
                drawImage(canvas);

                //Animating and drawing movable objects.
                ball.animate(canvas);
                ball.draw(canvas);
                if(touchTrackerBall != null) //No track ball appears until first touch.
                    touchTrackerBall.draw(canvas);

                //===========================================================================
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void clearScreen(Canvas c)
    {
        //This fills the screen with whatever color (r,g,b) you choose.
        c.drawRGB(155, 155, 0);
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
        pen.setColor(Color.BLUE);
        pen.setTypeface(Typeface.SANS_SERIF);
        pen.setTextSize(40);

        c.drawText("Hello", 200, 200, pen);
    }

    /**
     * Draws an Image to the screen.
     * The Image must be in the res/drawable folder.
     *
     * @param c the Canvas being drawn on.
     */
    public void drawImage(Canvas c)
    {
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.demo_image);
        c.drawBitmap(image, 200, 200, sharedPaint);
    }

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

    public void drawCircle(Canvas c) {
        c.drawCircle(100, 100, 60, sharedPaint);
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
        if (touchTrackerBall ==null)
        {
            touchTrackerBall = new PongBall();
            touchTrackerBall.setColor(Color.BLUE);
        }

        //Update the location of the touchTrackerBall
        touchTrackerBall.setX((int) event.getX());
        touchTrackerBall.setY((int) event.getY());

        //If the user touches in the circle, start a new Activity
        if(inCircle((int)event.getX(), (int)event.getY()))
        {
            startSecondActivity();
        }

        return true;
    }

    /**
     * Starts a new Activity!
     */
    public void startSecondActivity()
    {
        context.startActivity(new Intent(context, SecondActivity.class));
        //Toast is the name for popup messages in Android...
        Toast.makeText(context, "StartingNewActivity", Toast.LENGTH_SHORT).show();
    }

    /**
     * A method to determine if a point (x,y) is in a circle.
     * The circle being checked is centered at 100,100 with radius 60
     * (The circle from the drawCircle method in this demo.)
     * @param x
     * @param y
     * @return true if (x,y) is contained in the circle.
     */
    public boolean inCircle(int x, int y)
    {
        if(Math.abs(100-x) < 60 && Math.abs(100-y) < 60)
            return true;
        return false;
    }


}
