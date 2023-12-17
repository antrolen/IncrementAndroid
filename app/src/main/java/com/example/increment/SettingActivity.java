package com.example.increment;

import android.os.Bundle;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setLogTag("setting");
        setToastOnIncrement(" x1.5");
        setOnBackPressedCallback();
        initiate();
    }

    @Override
    public Integer increment(Integer value) {
        return  value + value / 2;
    }
}