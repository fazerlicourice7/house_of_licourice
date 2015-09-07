<<<<<<< HEAD
package com.example.cameraexample;

import java.io.File;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class mediaFile {
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	
	public Uri getOutputMediaUri(int type){
		Uri mediaURI;
		mediaURI = Uri.fromFile(getOutputMediaFile(type));
		return mediaURI;		
	}
	
	 private static File getOutputMediaFile(int type){
	        // To be safe, you should check that the SDCard is mounted
	        // using Environment.getExternalStorageState() before doing this.

	        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	                  Environment.DIRECTORY_PICTURES), "MyCameraApp");
	    
	        // Create the storage directory if it does not exist
	        if (! mediaStorageDir.exists()){
	            if (! mediaStorageDir.mkdirs()){
	                Log.d("MyCameraApp", "failed to create directory");
	                return null;
	            }
	        }

	        // Create a media file name
	        File mediaFile;
	        if (type == MEDIA_TYPE_IMAGE){
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "IMG_"+ ".jpg");
	        } else if(type == MEDIA_TYPE_VIDEO) {
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "VID_"+ ".mp4");
	        } else {
	            return null;
	        }

	        return mediaFile;
	    }
}
=======
package com.example.cameraexample;

import java.io.File;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class mediaFile {
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	
	public Uri getOutputMediaUri(int type){
		Uri mediaURI;
		mediaURI = Uri.fromFile(getOutputMediaFile(type));
		return mediaURI;		
	}
	
	 private static File getOutputMediaFile(int type){
	        // To be safe, you should check that the SDCard is mounted
	        // using Environment.getExternalStorageState() before doing this.

	        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	                  Environment.DIRECTORY_PICTURES), "MyCameraApp");
	    
	        // Create the storage directory if it does not exist
	        if (! mediaStorageDir.exists()){
	            if (! mediaStorageDir.mkdirs()){
	                Log.d("MyCameraApp", "failed to create directory");
	                return null;
	            }
	        }

	        // Create a media file name
	        File mediaFile;
	        if (type == MEDIA_TYPE_IMAGE){
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "IMG_"+ ".jpg");
	        } else if(type == MEDIA_TYPE_VIDEO) {
	            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	            "VID_"+ ".mp4");
	        } else {
	            return null;
	        }

	        return mediaFile;
	    }
}
>>>>>>> 0d018ee7d24f8eba23d577420e595cccce1748ca
