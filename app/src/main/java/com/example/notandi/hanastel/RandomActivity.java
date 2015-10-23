package com.example.notandi.hanastel;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

/**
 * Created by Altaris on 23-Oct-15.
 */

public class RandomActivity extends MainActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;

    private static final int SHAKE_THRESHOLD = 500;
    private long lastTime;
    private float x, y, z;
    private float last_x, last_y, last_z;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        long curTime = System.currentTimeMillis();

        // only allow one update every 400ms.
        if ((curTime - lastTime) > 400) {
            long diffTime = (curTime - lastTime);
            lastTime = curTime;

            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

            float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {
                Log.d("sensor", "shake detected w/ speed: " + speed);
                Toast.makeText(this, "shake detected w/ speed: " + speed + " and diffTime: " + diffTime, Toast.LENGTH_SHORT).show();

                // TODO: call function where we get random drink

            }
            last_x = x;
            last_y = y;
            last_z = z;
        }

        //Log.d("bla","x: " + event.values[0] + "\ny: " + event.values[1] + "\nz: " + event.values[2]);
        //Toast.makeText(this, "x: " + event.values[0] + "\ny: " + event.values[1] + "\nz: " + event.values[2], Toast.LENGTH_SHORT).show();

    }
}
