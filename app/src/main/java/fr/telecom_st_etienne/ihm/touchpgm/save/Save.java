package fr.telecom_st_etienne.ihm.touchpgm.save;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Save implements Comparable<Save>{
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private float tps;
    private int gameTime;

    @Override
    public int compareTo(Save save){
        return Float.compare(this.tps, save.getTps());
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTps() {
        return tps;
    }

    public void setTps(float tps) {
        this.tps = tps;
    }
}
