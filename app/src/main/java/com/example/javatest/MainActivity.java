package com.example.javatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getClientCheckFrag();
    }

    @SuppressLint("ResourceType")
    public void getClientCheckFrag() {
        fragmentManager.beginTransaction().add(R.id.mainFrameLayout, new CheckBoxFragment()).commit();
    }
}