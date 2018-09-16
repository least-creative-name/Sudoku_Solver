package com.example.adityapatel.sudokusolver;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.VolumeShaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.view.Window;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import java.io.IOException;
import java.util.List;


public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder theHolder;
    private Camera theCamera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        theCamera = camera;

        Log.e("SudokuSolver", "got to camera preview constructor without any issues");
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        theHolder = getHolder();
        theHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        theHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {



        // The Surface has been created, now tell the camera where to draw the preview.
        Camera.Parameters camParams = theCamera.getParameters();


        List<Camera.Size> presize_options = camParams.getSupportedPreviewSizes();
        Camera.Size preview_size = presize_options.get(0);

        /*
        for(Camera.Size best_size : presize_options){
            preview_size = best_size;
        }*/

        List<Camera.Size> picsize_options = camParams.getSupportedPreviewSizes();
        Camera.Size picture_size = picsize_options.get(0);


        /*
        for(Camera.Size best_size : picsize_options){
            picture_size = best_size;
        }*/


        if(this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
            camParams.set("orientation","portrait");
            theCamera.setDisplayOrientation(90);
            camParams.setRotation(90);
        }
        else{
            camParams.set("orientation","landscape");
            theCamera.setDisplayOrientation(0);
            camParams.setRotation(0);
        }


        camParams.setPreviewSize(preview_size.width, preview_size.height);
        camParams.setPictureSize(picture_size.width, picture_size.height);

        if(preview_size.width == picture_size.width && preview_size.height == picture_size.height)
            Log.e("SudokuSolver", "Pic size and pre size match, YAY "+preview_size.height+" and "+preview_size.width);


        theCamera.setParameters(camParams);



        try {
            theCamera.setPreviewDisplay(holder);
            theCamera.startPreview();
            Log.e("SudokuSolver", "Successfully set up camera preview ");
        } catch (IOException e) {
            Log.e("SudokuSolver", "Error setting camera preview: " + e.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
        theCamera.stopPreview();
        theCamera.release();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (theHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            theCamera.stopPreview();
        } catch (Exception e){
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here
        setFocus(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        // start preview with new settings
        try {
            theCamera.setPreviewDisplay(theHolder);
            theCamera.startPreview();

        } catch (Exception e){
            Log.d("SudokuSolver", "Error starting camera preview: " + e.getMessage());
        }
    }

    private void setFocus(String mParameter) {
        Camera.Parameters mParameters = theCamera.getParameters();
        mParameters.setFocusMode(mParameter);
        theCamera.setParameters(mParameters);
    }
}
