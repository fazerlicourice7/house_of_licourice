package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends Activity {
	public final static String INPUT = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
    
    public void printInput(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText textbox = (EditText) findViewById(R.id.EditText1);
        String input = textbox.getText().toString();
		intent.putExtra(INPUT, input);
		startActivity(intent);
        
    }
    
}
