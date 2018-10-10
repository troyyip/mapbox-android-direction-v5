package com.mapbox.direction.mapbox_direction_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    public static String MAPBOX_ACCESS_TOKEN = "pk.eyJ1IjoidHJveXllMDgyNiIsImEiOiJjamtkZWkxYnU0MWRpM3hudHJqazZrdGNnIn0.C8RkunluXjaQBtM4xv7_bA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
