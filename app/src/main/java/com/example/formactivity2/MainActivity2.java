package com.example.formactivity2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button toNextActivity, toFragment1, toFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toNextActivity = findViewById(R.id.toNextActivity);
        toFragment1 = findViewById(R.id.tofragment1);
        toFragment2 = findViewById(R.id.tofragment2);

        toNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        toFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadFragment(new Fragment1());

            }

        });
        toFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new Fragment2());

            }
        });

    }

    private void LoadFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.Container,fragment);
        fragmentTransaction.commit();
    }
}