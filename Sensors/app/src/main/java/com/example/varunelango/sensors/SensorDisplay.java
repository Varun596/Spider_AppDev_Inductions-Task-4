package com.example.varunelango.sensors;

import android.graphics.Color;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class SensorDisplay extends ActionBarActivity implements SensorEventListener{
    Sensor sense;
    SensorManager sm;
    int type;
    TextView X,Y,Z,value,heading;
    String units="",title="";
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_display);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sense=sm.getDefaultSensor(android.hardware.Sensor.TYPE_PRESSURE);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            type=bundle.getInt("TypeOfSensor");
        }
       switch (type){
            case 0:
                sense=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                title="ACCELEROMETER";
                units=" m/s\u00B2";
                break;
            case 1:
                sense=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                title="GYROSCOPE";
                units=" rad/s";
                break;
            case 2:
                sense=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
                title="LIGHT SENSOR";
                units=" lx";
                break;
            case 3:
                sense=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                title="MAGNETIC SENSOR";
                units=" \u00B5T";
                break;
            case 4:
                sense=sm.getDefaultSensor(Sensor.TYPE_PRESSURE);
                title="PRESSURE SENSOR";
                units=" hPa";
                break;
            case 5:
                sense=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                title="";
                units=" cms";

        }
        heading=(TextView)findViewById(R.id.Heading);
        heading.setText(title);
        sm.registerListener(this,sense,SensorManager.SENSOR_DELAY_NORMAL);
        X=(TextView)findViewById(R.id.X);
        Y=(TextView)findViewById(R.id.Y);
        Z=(TextView)findViewById(R.id.Z);
        value=(TextView)findViewById(R.id.Value);
        layout = (RelativeLayout) findViewById(R.id.RL);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        if(type==0||type==1||type==3) {
            X.setText("X = " + Float.toString(event.values[0]) + units);
            Y.setText("Y = " + Float.toString(event.values[1]) + units);
            Z.setText("Z = " + Float.toString(event.values[2]) + units);
        }


        else if(type==5)
        {

            if(event.values[0]==0)
            {
                value.setText(Float.toString(event.values[0])+units);
                layout.setBackgroundColor(Color.BLACK);
                value.setTextColor(Color.WHITE);

            }
            else
            {
                value.setText(Float.toString(event.values[0])+units);
                layout.setBackgroundColor(Color.WHITE);
                value.setTextColor(Color.BLACK);
            }
        }
        else{
            value.setText(Float.toString(event.values[0])+units);
        }
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }
}
