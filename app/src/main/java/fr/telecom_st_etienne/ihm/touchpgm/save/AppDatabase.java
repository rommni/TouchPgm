package fr.telecom_st_etienne.ihm.touchpgm.save;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Save.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SaveDao saveDao();
}
