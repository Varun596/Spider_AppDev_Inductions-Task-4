package com.example.varunelango.sensors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter  {

    private Context context;
    private String[] SensorNames;
    int image[];

    public CustomAdapter(Context context, String[] SensorNames, int[] image){
        this.context=context;
        this.SensorNames=SensorNames;
        this.image=image;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gv;
        if(convertView==null){
            gv=new View(context);
            gv=inflater.inflate(R.layout.custom_grid_item,null);

            TextView tv = (TextView)gv.findViewById(R.id.SensorName);
            tv.setText(SensorNames[position]);

            ImageView iv=(ImageView)gv.findViewById(R.id.SensorImage);
            iv.setImageResource(image[position]);

            }
        else gv=(View)convertView;
        return gv;
        }


    public int getCount(){
        return SensorNames.length;
    }

    public Object getItem(int position){
        return null;
    }

     public long getItemId(int position){
        return 0;
    }

}
