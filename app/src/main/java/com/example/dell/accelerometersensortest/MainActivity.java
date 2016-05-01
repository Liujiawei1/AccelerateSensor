package com.example.dell.accelerometersensortest;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
            protected void onDestroy(){
        super.onDestroy();
        sensorManager.unregisterListener(listener);
    }

        SensorEventListener listener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float xValue=Math.abs(event.values[0]);//因为加速度有可能是负数，所以要取绝对值
                float yValue=Math.abs(event.values[1]);
                float zValue=Math.abs(event.values[2]);
                if(xValue>15||yValue>15||zValue>15){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://210.45.128.31"));
                    startActivity(intent);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

}
