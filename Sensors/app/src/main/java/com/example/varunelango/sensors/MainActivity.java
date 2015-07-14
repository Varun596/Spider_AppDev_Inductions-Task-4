package com.example.varunelango.sensors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String[] SensorNames=new String[]{"Accelerometer","Gyroscope","Light Sensor","Magnetic Sensor","Pressure Sensor","Proximity Sensor"};
    int image[] = new int[]{R.mipmap.accelerometer,R.mipmap.gyroscope,R.mipmap.light,R.mipmap.magnetic,R.mipmap.pressure,R.mipmap.proximity};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView) findViewById (R.id.SensorGrid);

        gv.setAdapter(new CustomAdapter(this,SensorNames,image));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent=new Intent(getApplicationContext(),SensorDisplay.class);
                    intent.putExtra("TypeOfSensor",i);
                    startActivity(intent);

            }
        });


    }

}
