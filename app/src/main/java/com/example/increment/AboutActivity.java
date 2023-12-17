package com.example.increment;

import android.os.Bundle;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setLogTag("about");
        setToastOnIncrement("+10%");
        setOnBackPressedCallback();
        initiate();
    }

    public Integer increment(Integer value) {
        return value + (int)Math.round(value.doubleValue() / 10.0);
    }
}