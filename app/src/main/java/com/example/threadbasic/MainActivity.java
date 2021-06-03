package com.example.threadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    WorkerThread wt;
    boolean running = true;
    final String TAG = "THREAD2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        running = true;
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (i = 0; i<20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                    }
                    Log.v(TAG, "Runnable time=" + i);
                }
            }
        });
        wr.start();
        Log.v(TAG, "Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.d(TAG, "Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Now I am in onPause");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "Now I am in onResume");
    }
}