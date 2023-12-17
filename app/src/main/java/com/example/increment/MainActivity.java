package com.example.increment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.increment.tools.DataNames;

import java.util.Objects;

import com.example.increment.tools.ActivitiesRequestCodes;

public class MainActivity extends BaseActivity {

//    Double counter = 0.0d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLogTag("main");
        setToastOnIncrement("+1");

        Intent intent = getIntent();
        if(intent != null){
            counter = intent.getIntExtra(DataNames.getCounterName(), 0);
        }
        Objects.requireNonNull(getSupportActionBar())
                .setTitle(String.valueOf(counter));

        Log.e("main", "onCreate");
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putDouble(DataNames.getCounterName(), counter);
//        Log.w("main", "onSave");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        counter = savedInstanceState.getDouble(DataNames.getCounterName(), 0.0);
//        getSupportActionBar().setTitle(String.valueOf(counter));
//
//        Log.d("main", "onRestore");
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 200 && data != null) {
            switch (ActivitiesRequestCodes.getValue(requestCode)) {
                case START:
                case SETTING:
                case ABOUT:
                    counter = data.getIntExtra(DataNames.getCounterName(), 0);
                    getSupportActionBar().setTitle(String.valueOf(counter));
            }
        }
        Log.d(logTag, "onActivityResult");
    }


    public void onToStartActivity(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        intent.putExtra(DataNames.getCounterName(), counter);

        startActivityForResult(intent, ActivitiesRequestCodes.START.ordinal());
    }

    public void onToSettingActivity(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        intent.putExtra(DataNames.getCounterName(), counter);
        startActivityForResult(intent, ActivitiesRequestCodes.SETTING.ordinal());
    }



    public void onToAboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra(DataNames.getCounterName(), counter);
        startActivityForResult(intent, ActivitiesRequestCodes.ABOUT.ordinal());
    }

    @Override
    public Integer increment(Integer value) {
        return value + 1;
    }
}