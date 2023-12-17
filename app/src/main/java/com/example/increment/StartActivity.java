package com.example.increment;

import android.os.Bundle;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setLogTag("start");
        setToastOnIncrement("+3");
        setOnBackPressedCallback();
        initiate();
    }

    @Override
    public Integer increment(Integer value) {
        return  value + 3;
    }
}