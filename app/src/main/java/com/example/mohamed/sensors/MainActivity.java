package com.example.mohamed.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager =
                (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors =
                sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        Log.d("MySensors", sensors.toString());
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        Log.d("MySensor","-- " + Long.toString(event.timestamp) + " -- x = " + x +  " -- y = " + y + " -- z = " + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
