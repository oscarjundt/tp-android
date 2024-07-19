package com.example.myyoutubeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private EditText Title;
    private EditText Desc;
    private EditText Url;
    private Button Add;
    private Button Del;
    private Switch favorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.favorie = findViewById(R.id.switch2);
        this.Title = findViewById(R.id.editTitle);
        this.Desc = findViewById(R.id.editDesc);
        this.Url = findViewById(R.id.editUrl);
        this.Add = findViewById(R.id.button);
        this.Del = findViewById(R.id.button2);
        Intent intent = getIntent();
        long id = (long)intent.getSerializableExtra("question");
        YoutubeVideo youtubeVideo = YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().find(id);
        this.Title.setText(youtubeVideo.getTitre());
        this.Desc.setText(youtubeVideo.getDesc());
        this.Url.setText(youtubeVideo.getUrl());
        this.favorie.setChecked(getBoolean(youtubeVideo.getFavorie()));
        this.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Title.getText().toString().equals("") && !Url.getText().toString().equals("") && !Desc.getText().toString().equals("")) {
                    YoutubeVideo Video = new YoutubeVideo();
                    Video.setId(id);
                    Video.setFavorie(getInt(favorie.isChecked()));
                    Video.setTitre(Title.getText().toString());
                    Video.setDesc(Desc.getText().toString());
                    Video.setUrl(Url.getText().toString());
                    YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().upd(Video);
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
                YoutubeVideoDB.getDb(getApplicationContext()).youtubeVideoDAO().del(youtubeVideo);
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

    private int getInt(boolean bool){
        int number = 0;
        if(bool){
            number=1;
        }
        return number;
    }

    private boolean getBoolean(int number){
        boolean bool=false;
        if(number==1){
            bool = true;
        }
        return bool;
    }

}