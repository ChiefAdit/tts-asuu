package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape layout
            setContentView(R.layout.activity_main);
        } else {
            // Portrait layout
            setContentView(R.layout.fragment_container);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HeadlinesFragment())
                    .commit();
        }
    }
}
