package com.example.myyoutubeapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {YoutubeVideo.class}, version = 1)
public abstract class YoutubeVideoDB extends RoomDatabase {
    private static final String DATABASE_NAME = "test";

    public static YoutubeVideoDB getDb(Context context){
        return Room.databaseBuilder(context,YoutubeVideoDB.class,DATABASE_NAME).allowMainThreadQueries().build();
    }

    public abstract YoutubeVideoDAO youtubeVideoDAO();
}
