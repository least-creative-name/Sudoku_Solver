package com.example.adityapatel.sudokusolver;


import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.view.Window;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.graphics.BitmapFactory;

import com.example.adityapatel.sudokusolver.models.Classification;
import com.example.adityapatel.sudokusolver.models.Classifier;
import com.example.adityapatel.sudokusolver.models.TensorFlowClassifier;

import java.util.ArrayList;
import java.util.List;

public class Camera_Activity_UI extends AppCompatActivity {

    private FrameLayout camera_view;
    private RelativeLayout overlay;
    private CameraPreview showCamera;
    private Camera theCamera;
    private ImageView inputPic;

    private List<Classifier> mClassifiers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //to remove title bar of app
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // set the view of the activity and get references to our views
        setContentView(R.layout.activity_camera___ui);
        camera_view = (FrameLayout) findViewById(R.id.camera_view);
        overlay = (RelativeLayout) findViewById(R.id.overlay);

        //theCamera = Camera.open();

        if(checkCameraHardware(this)){
            Log.e(getString(R.string.app_name), "Camera exists, for real");
        }

        theCamera = getCameraInstance();

        showCamera = new CameraPreview(this, theCamera);

        camera_view.addView(showCamera);

        final Button GoBack = (Button) findViewById(R.id.GoBack);

        inputPic = (ImageView) findViewById(R.id.inputPic);


        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //how to change the values from the main activitiy
                //MainActivity.matrix[0][0].setInput_Value(5);
                //MainActivity.grid[0][0].setText(Integer.toString(5));

                finish();
            }
        });


        final Button captureImage = (Button) findViewById(R.id.capture);

        final Camera.PictureCallback picCallBack = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                camera_view.removeAllViews();
                overlay.removeAllViews();
                overlay.setBackgroundResource(0);

                try
                {
                    Bitmap bmp=BitmapFactory.decodeByteArray(data,0,data.length);
                    if (bmp!=null)
                    {
                        Log.e("SudokuSolver", " the cropped dimension is "+bmp.getWidth());
                        int dimension = bmp.getWidth();
                        Bitmap cropped_pic = Bitmap.createBitmap(bmp, 0, 0, dimension, dimension);
                        Bitmap [][] sections = new Bitmap[9][9];
                        int img_dim = 28;
                        for(int i = 0; i<9; i++){
                            for(int j = 0; j<9; j++){
                                Bitmap temp = Bitmap.createBitmap(cropped_pic, j*dimension/9, i*dimension/9, dimension/9, dimension/9);
                                //new cell pic is dimension/9 in length, so cut off 10% on all sides
                                Bitmap temp_Padded = Bitmap.createBitmap(bmp, dimension/90, dimension/90, (dimension*8)/90, (dimension*8)/90);
                                sections[i][j] = Bitmap.createScaledBitmap(temp_Padded, img_dim, img_dim, true);
                            }
                        }

                        int[][][] pixels = new int[9][9][img_dim*img_dim];
                        //below are the grey-scaled pixels (extreme constrast, if any green exists in pixel, then set black
                        // else make it white)
                        float[][][] GSpixels = new float[9][9][img_dim*img_dim];

                        for(int i = 0; i<9; i++){
                            for(int j = 0; j<9; j++){
                                sections[i][j].getPixels(pixels[i][j], 0, 28, 0, 0, img_dim, img_dim);
                                //System.out.println(pixels[i][j][0]);
                                for(int k = 0; k<(img_dim * img_dim); k++){
                                    //based of how much 'green' there is in pixel, give it a value
                                    //between 0 and 1, 0 being white (no green) and 1 begin black (very green)
                                    //this 0= white and 1=black color scheme is what was in MNIST data... I cry...
                                    int pix = pixels[i][j][k];
                                    int g = pix & 0xFF;
                                    //consider the blue amounts and red amounts afterwards, find max of 3 and use that
                                    int b = pix & 0xFF00;
                                    b = b>>8;
                                    int r = pix & 0xFF0000;
                                    r = r>>16;
                                    GSpixels[i][j][k] = (float)((0xFF - Math.max(Math.max(g,b), r))/255.0);
                                }
                            }
                        }

                        ///////////////////////////////////////////////////////////////////////////////////
                        //testing with entire image
                        ///////////////////////////////////////////////////////////////////////////////////
                        Bitmap entire_image = Bitmap.createScaledBitmap(convert_to_GS(cropped_pic), img_dim, img_dim, false);
                        int []entire_image_pixels  = new int[img_dim*img_dim];
                        entire_image.getPixels(entire_image_pixels, 0, img_dim, 0, 0, img_dim, img_dim);
                        float []GS_entire_image_pixels = new float[img_dim*img_dim];
                        for(int i = 0; i<img_dim*img_dim; i++){
                            int pix = entire_image_pixels[i];
                            int g = pix & 0xFF;
                            GS_entire_image_pixels[i] = (float)((0xFF - g)/255.0);
                        }
                        //entire_image.setPixels(high_contrast, 0, img_dim, 0, 0, img_dim, img_dim);
                        int current = 1008;
                        Bitmap image_rounded = Bitmap.createScaledBitmap(convert_to_GS(cropped_pic), current, current, false);
                        image_rounded = convert_to_GS(image_rounded);
                        for(int i = 0; i<2; i++) {
                            int[] test = new int[current * current];
                            image_rounded.getPixels(test, 0, current, 0, 0, current, current);
                            current = current / 2;
                            int[] out_array = new int[current * current];
                            out_array = pool(test);
                            image_rounded.setPixels(out_array, 0, current, 0, 0, current, current);
                        }
                        entire_image = Bitmap.createBitmap(image_rounded, 0, 0, current,current);
                        //System.out.println("good up to point 1");
                        float [][][] classifier_input = new float[9][9][img_dim*img_dim];
                        Bitmap [][] segments = new Bitmap[9][9];
                        for(int i = 0; i<9; i++){
                            for(int j = 0; j<9; j++){
                                Bitmap temp = Bitmap.createBitmap(image_rounded, j*img_dim, i*img_dim, img_dim, img_dim);
                                segments[i][j] = temp;
                                //System.out.println("created temp");
                                int []working_pixels = new int[img_dim*img_dim];
                                temp.getPixels(working_pixels, 0, img_dim, 0,0,img_dim,img_dim);

                                //System.out.println("got the pixels");
                                for(int k = 0; k<working_pixels.length; k++){
                                    int pix = working_pixels[k];
                                    //System.out.println("read from working pixels");
                                    int g = pix & 0xFF;
                                    classifier_input[i][j][k]=(float)((0xFF - g)/255.0);
                                }

                                //System.out.println("good up to row "+i+" and col "+j);
                            }
                        }

                        entire_image = Bitmap.createScaledBitmap(entire_image, 1000, 1000, false);

                        /////////////////////////////////////////////////////////////////////////////////////
                        load_model();
                        Log.e("SudokuSolver", " the number of classifiers are "+mClassifiers.size());
                        for(int i = 0; i<9; i++) {
                            for(int j = 0; j<9; j++) {
                                Classifier intelligence = mClassifiers.get(0);
                                //final Classification result = intelligence.recognize(GSpixels[0][0]);
                                final Classification result = intelligence.recognize(classifier_input[i][j]);
                                if((result.getLabel() != null && result.getConf()>0.85)&& !result.getLabel().equals("0")){
                                    String prediction = result.getLabel();
                                    MainActivity.grid[i][j].setText(prediction);
                                    MainActivity.matrix[i][j].setInput_Value(Integer.parseInt(prediction));
                                    Log.e("SudokuSolver", " the prediction class is "+prediction+" for row "+i+" and col "+j);
                                }
                            }
                        }
                        Log.e("SudokuSolver", " done");






                        inputPic.setImageBitmap(entire_image);

                    }
                }
                catch (Exception e)
                {
                    Log.e("Create file error : ",e.getMessage());
                }

            }
        };

        captureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(theCamera != null){
                    theCamera.takePicture(null, null, picCallBack);


                }


            }
        });



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // Get the preview size
        int previewWidth = camera_view.getMeasuredWidth(),
                previewHeight = camera_view.getMeasuredHeight();


        // Set the height of the overlay so that it makes the preview a square
        RelativeLayout.LayoutParams overlayParams = (RelativeLayout.LayoutParams) overlay.getLayoutParams();
        overlayParams.height = previewHeight *7/16;

        Log.e("SudokuSolver", " the preview width is "+previewWidth);
        Log.e("SudokuSolver", " the preview height is "+previewHeight);
        Log.e("SudokuSolver", " the overlay height is "+overlayParams.height);
        overlay.setLayoutParams(overlayParams);

    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            Log.e("SudokuSolver", "Great success, got a camera going");
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.e("SudokuSolver", "Camera is not available, trust me");
        }
        return c; // returns null if camera is unavailable
    }


    private  void load_model(){
        try {
            mClassifiers.add(TensorFlowClassifier.create(getAssets(), "TensorFlow", "MNIST_CNN_Classifier.pb", "labels.txt", 28, "input_image_here", "probability_output", false));
            //mClassifiers.add(TensorFlowClassifier.create(getAssets(), "TensorFlow","opt_mnist_convnet-tf.pb", "labels.txt", 28,"input", "output", true));
        }
        catch (final Exception e) {
            //if they aren't found, throw an error!
            throw new RuntimeException("Error initializing classifiers!", e);
        }
    }

    public static Bitmap convert_to_GS (Bitmap original){
        Bitmap final_image = Bitmap.createBitmap(original.getWidth(), original.getHeight(),original.getConfig());
        int A,R,G,B;
        int colorPixel;
        int width = original.getWidth();
        int height = original.getHeight();

        for(int x= 0; x<height; x++){
            for(int y = 0; y<width; y++){
                colorPixel = original.getPixel(x,y);
                A = Color.alpha(colorPixel);
                R = Color.red(colorPixel);
                G = Color.green(colorPixel);
                B = Color.blue(colorPixel);

                R = (R+G+B)/3;
                if(R > 89)
                    R = 255;
                G = R;
                B = R;

                final_image.setPixel(x,y, Color.argb(A,R,G,B));
            }
        }

        return(final_image);


    }

    public int[] pool(int[]original){
        int dimension = (int)Math.sqrt((double)(original.length));
        System.out.println("old dimension "+dimension);
        int half = dimension/2;
        System.out.println("new dimension "+half);
        int[]result = new int[half*half];
        for(int i = 0; i<half; i++){
            for(int j = 0; j<half; j++){
                int row = i*2;
                int col = j*2;
                int position = (row*dimension)+col;
                int first = Math.min(original[position], original[position+1]);
                int second = Math.min(original[position+dimension], original[position+dimension+1]);
                result[(i*half) + j] = Math.min(first, second);
            }
        }
        return(result);
    }

}
