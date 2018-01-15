package fr.telecom_st_etienne.ihm.touchpgm.save;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SaveDao {

    @Query("SELECT * FROM save ORDER BY tps DESC")
    List<Save> getAllOrderByTps();
    @Query("SELECT tps FROM save ORDER BY tps ASC")
    List<Float> getTpsOrderByTps();

    @Insert
    void insert(Save save);

    @Delete
    void delete(Save save);
}
