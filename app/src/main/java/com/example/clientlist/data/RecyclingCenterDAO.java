package com.example.clientlist.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface RecyclingCenterDAO {

    @Insert
    public void insert(RecyclingCenter recyclingCenter);

    @Update
    public void update(RecyclingCenter recyclingCenter);

    @Delete
    public void delete(RecyclingCenter recyclingCenter);

    @Query("SELECT * FROM recycler_center")
    public List<RecyclingCenter> getRecyclingCenterList();

    @Query("SELECT * FROM recycler_center where id=:id")
    public RecyclingCenter getRecyclingCenter(Long id);
}
