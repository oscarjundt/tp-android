package com.example.myyoutubeapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Switch favorie;
    List<YoutubeVideo> youtubeVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        favorie = findViewById(R.id.switch1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().delAll();
        youtubeVideos = YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().findAll();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(youtubeVideos,this);
        recyclerView.setAdapter(adapter);
        favorie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    youtubeVideos =YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().getFavorite();
                    Adapter adapter = new Adapter(youtubeVideos,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
                else{
                    youtubeVideos =YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().findAll();
                    Adapter adapter = new Adapter(youtubeVideos,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }
        });

        // Initialisez les données

        //text.setText(YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().find(1).getUrl());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent intent  = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}