
package com.pxpepe.applifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String status = "";
    int order = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = "Activity Created - onCreate";
        displayStatus();
    }

    @Override
    protected void onStart() {
        super.onStart();
        status = "Activity Started - onStart";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        status = "Restoring Instance - onRestoreInstanceState";
        displayStatus();

    }

    @Override
    protected void onResume() {
        super.onResume();
        status = "Activity Resumed - onResume";
        displayStatus();
    }

    @Override
    protected void onPause() {
        super.onPause();
        status = "Activity Paused - onPause";
        displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving instance state
        super.onSaveInstanceState(outState);
        status = "Saving Instance - onSaveInstanceState";
        displayStatus();

    }

    @Override
    protected void onStop() {
        //activity stopped
        super.onStop();
        status = "Activity Stopped - onStop";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        //activity destroyed
        super.onDestroy();
        status = "Activity Destroyed - onDestroy";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        //activity destroyed
        super.onRestart();
        status = "Activity Restarted - onRestart";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
