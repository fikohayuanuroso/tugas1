package com.example.formactivity2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyler extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdopterData adopterData;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);

        recyclerView =findViewById(R.id.rvData);
        listData = new ArrayList<>();

        for (int i=0;i<10;i++){
            listData.add("Data ke "+i);
        }
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adopterData = new AdopterData(this,listData);
        recyclerView.setAdapter(adopterData);
        adopterData.notifyDataSetChanged();
    }
}