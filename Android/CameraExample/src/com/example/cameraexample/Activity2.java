<<<<<<< HEAD
package com.example.cameraexample;

import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Activity2 extends Activity {
	Intent media;
    protected void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_end);
	    media = getIntent();
    }
    
    protected void save(){
    	
    }
    
    protected void delete(){
    	Uri location = media.getData();
    	File Location = new File(location.getPath());
    	Location.delete();
    }
    
   


import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Activity2 extends Activity {
	Intent media;
    protected void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_end);
	    media = getIntent();
    }
    
    protected void save(){
    	
    }
    
    protected void delete(){
    	Uri location = media.getData();
    	File Location = new File(location.getPath());
    	Location.delete();
    }
    
   

}
>>>>>>> 0d018ee7d24f8eba23d577420e595cccce1748ca
