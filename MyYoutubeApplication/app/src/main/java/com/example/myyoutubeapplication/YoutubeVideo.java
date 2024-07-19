package com.example.myyoutubeapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class YoutubeVideo  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long Id;

    @ColumnInfo(name = "titre")
    private String titre;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "categotrie")
    private String categotrie;

    @ColumnInfo(name = "favorie")
    private int favorie;

    public long getId() {
        return Id;
    }

    public YoutubeVideo(){

    }

    public YoutubeVideo(long id, String titre, String desc, String url, String categotrie, int favorie) {
        Id = id;
        this.titre = titre;
        this.desc = desc;
        this.url = url;
        this.categotrie = categotrie;
        this.favorie = favorie;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategotrie() {
        return categotrie;
    }

    public void setCategotrie(String categotrie) {
        this.categotrie = categotrie;
    }

    public int getFavorie() {
        return favorie;
    }

    public void setFavorie(int favorie) {
        this.favorie = favorie;
    }
}
