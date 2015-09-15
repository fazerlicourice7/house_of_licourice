package com.example.balanagav.cameraexample;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 18balanagav on 9/11/2015.
 */
public class mediaFile {

    private static final int MEDIA_TYPE_IMAGE = 1;
    private static final int MEDIA_TYPE_VIDEO = 2;

    /** Create a file Uri for saving an image or video */
    public static Uri getOutputMediaFileUri(int type){
        File mediafile = getOutputMediaFile(type);
        Uri mediaUri;
        if(mediafile==null){
            Log.d("CameraExample","something didn't work");
            return null;
        }else{
        mediaUri =  Uri.fromFile(mediafile);
        }
        return mediaUri;
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){

        String externalStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("CameraExample", externalStorage);
        File mediaStorageDir = new File(externalStorage, "CameraExample");
        Log.d("Location Exists:", String.valueOf(mediaStorageDir.exists()));
        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("CameraExample", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }
}
