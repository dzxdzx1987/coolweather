package com.coolweather.light_sensor_app;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LightSensorManager lightSensorManager;
    private Button startBtn;
    private Button stopBtn;
    private TextView brightnessValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightSensorManager = LightSensorManager.getInstance();

        startBtn = findViewById(R.id.start);
        stopBtn = findViewById(R.id.stop);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        brightnessValue = findViewById(R.id.value);
        try {
            int value = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
            brightnessValue.setText(value + "");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start :
                lightSensorManager.start(this);
                break;
            case R.id.stop :
                lightSensorManager.stop();
                break;
            default:
                break;
        }
    }
}
