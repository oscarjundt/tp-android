package com.example.myyoutubeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText Title;
    private EditText Desc;
    private EditText Url;
    private Button Add;
    private Button Del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.Title = findViewById(R.id.editTitle);
        this.Desc = findViewById(R.id.editDesc);
        this.Url = findViewById(R.id.editUrl);
        this.Add = findViewById(R.id.button);
        this.Del = findViewById(R.id.button2);
        this.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Url.getText().toString().toLowerCase().contains("https://") && !Title.getText().toString().equals("") && !Url.getText().toString().equals("") && !Desc.getText().toString().equals("")) {
                    YoutubeVideo Video = new YoutubeVideo();
                    Video.setTitre(Title.getText().toString());
                    //Video.setFavorie(0);
                    Video.setDesc(Desc.getText().toString());
                    Video.setUrl(Url.getText().toString());
                    YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().add(Video);
                    Intent secondActivityIntent = new Intent(
                            getApplicationContext(), MainActivity.class
                    );
                    startActivity(secondActivityIntent);
                }
                else{
                    Toast toast = new Toast(getApplicationContext());
                    toast.setText("Champ non remplis");
                    toast.show();
                }
            }
        });
        this.Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivityIntent = new Intent(
                        getApplicationContext(), MainActivity.class
                );
                startActivity(secondActivityIntent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}