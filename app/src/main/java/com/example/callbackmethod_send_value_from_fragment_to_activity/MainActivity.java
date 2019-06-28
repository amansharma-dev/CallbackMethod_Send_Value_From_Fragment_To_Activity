package com.example.callbackmethod_send_value_from_fragment_to_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DetailFragment.FragmentListener {


    public static final String TAG = "main_activity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.showFragmentBtn);


    }

    public void showFragment(View view){

        button.setVisibility(View.GONE);

        DetailFragment  detailFragment = new DetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.frame_container,detailFragment,TAG)
                .commit();
    }


    @Override
    public void sendValues(String fName, String lName, int age) {
        Log.i(TAG,"First Name:- "+fName+", Last Name:- "+lName+", Age:- "+age+".");

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
        if(fragment!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }

        button.setVisibility(View.VISIBLE);
    }
}
