package memory.game.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        Typeface future= Typeface.createFromAsset(getAssets(),
                "fonts/future.ttf");

        Button eightByEight = (Button) findViewById(R.id.button2);

        eightByEight.setTypeface(future);

        Button threeBythree = (Button) findViewById(R.id.button);

        threeBythree.setTypeface(future);

        Button twelveBytwelve = (Button) findViewById(R.id.button3);

        twelveBytwelve.setTypeface(future);
    }

}
