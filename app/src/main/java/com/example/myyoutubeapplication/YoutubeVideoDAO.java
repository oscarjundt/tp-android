package com.example.myyoutubeapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface YoutubeVideoDAO {

    @Query("SELECT * FROM YoutubeVideo WHERE Id=:id")
    public YoutubeVideo find(long id);


    @Query("SELECT * FROM youtubevideo WHERE favorie=1")
    public List<YoutubeVideo> getFavorite();


    @Query("SELECT * FROM YoutubeVideo")
    public List<YoutubeVideo> findAll();


    @Insert
    public void add(YoutubeVideo... youtubeVideos);


    @Update
    public void upd(YoutubeVideo... youtubeVideos);

    @Query("DELETE FROM YoutubeVideo")
    public void delAll();


    @Delete
    public void del(YoutubeVideo... youtubeVideos);
}
