package com.example.prayapp.data.local.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PrayDao {
    @Insert
    void insert(Prays prays);

    @Update
    void update(Prays prays);

    @Delete
    void delete(Prays prays);

    @Query("DELETE FROM prayTable")
    void deleteAllPrays();

    @Query("SELECT * FROM prayTable")
    LiveData<List<Prays>> getAllPrays();
}
