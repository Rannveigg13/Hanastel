package com.example.notandi.hanastel;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Altaris on 23-Oct-15.
 */

public class RandomActivity extends MainActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;
    ImageView imageView;
    Animation animRotate;

    private String[] cocktails = {"The Juicy Lucy", "Sex on the beach", "Martini", "Volcano", "Sleipur Garpur"};

    private static final int SHAKE_THRESHOLD = 300;
    private long lastTime;
    private float x, y, z;
    private float last_x, last_y, last_z;
    //private boolean isShaking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        imageView = (ImageView)findViewById(R.id.animatedImage);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        long curTime = System.currentTimeMillis();

        // only allow one update every 450ms.
        if ((curTime - lastTime) > 450) {
            long diffTime = (curTime - lastTime);
            lastTime = curTime;

            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

            float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {
                //Log.d("sensor", "shake detected w/ speed: " + speed);
                //Toast.makeText(this, "shake detected w/ speed: " + speed + " and diffTime: " + diffTime, Toast.LENGTH_SHORT).show();

                // TODO: call function where we get random drink

                //Log.d("tag ", String.valueOf(i));
                Random r = new Random();
                final int i = r.nextInt(5) + 0;

                // Execute code after 0.3 sec
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        int d = i;
                        Log.d("\ncocktail: ", cocktails[d] + "\n");
                        imageView.startAnimation(animRotate);
                        Toast.makeText(getApplicationContext(), cocktails[d], Toast.LENGTH_SHORT).show();
                    }
                }, 300);


            }
            last_x = x;
            last_y = y;
            last_z = z;
        }

        //Log.d("bla","x: " + event.values[0] + "\ny: " + event.values[1] + "\nz: " + event.values[2]);
        //Toast.makeText(this, "x: " + event.values[0] + "\ny: " + event.values[1] + "\nz: " + event.values[2], Toast.LENGTH_SHORT).show();

    }
}
