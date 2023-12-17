package com.example.increment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.increment.tools.DataNames;
import com.example.increment.tools.Incremental;
import com.google.android.material.snackbar.Snackbar;

public class BaseActivity extends AppCompatActivity implements Incremental {
    Integer counter = 0;
    String logTag = "start";
    int backCallResultCode = 200;

    String toastOnIncrement = "";

    protected void setLogTag(String value){
        logTag = value;
    }
    protected  void setToastOnIncrement(String message){
        toastOnIncrement = message;
    }

    protected void setOnBackPressedCallback(){
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                onBackToMainActivity(null);
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }



    @Override
    public Integer increment(Integer value) {
        return null;
    }

    protected  void initiate(){
        counter = getIntent().getIntExtra(DataNames.getCounterName(), 0);
        getSupportActionBar().setTitle(String.valueOf(counter));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(DataNames.getCounterName(), counter);
        Log.w(logTag, "onSave");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(DataNames.getCounterName(), 0);
        getSupportActionBar().setTitle(String.valueOf(counter));

        Log.d(logTag, "onRestore");
    }

    public void onBackToMainActivity(View view) {
        Intent intent = new Intent();
        intent.putExtra(DataNames.getCounterName(), counter);
        setResult(backCallResultCode, intent);

        Log.d(logTag, "onBackToMainActivity");
        finish();

    }

    public void onIncrement(View view) {
        counter = increment(counter);
        getSupportActionBar().setTitle(String.valueOf(counter));

//        Toast.makeText(this, toastOnIncrement, Toast.LENGTH_SHORT).show();

        Snackbar.make(view, toastOnIncrement, Snackbar.LENGTH_SHORT).show();
        Log.i(logTag, toastOnIncrement);
    }

}
