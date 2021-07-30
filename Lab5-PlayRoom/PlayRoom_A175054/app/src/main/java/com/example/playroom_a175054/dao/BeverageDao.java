package com.example.playroom_a175054.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.playroom_a175054.entities.Beverage;

import java.util.List;

@Dao
public interface BeverageDao {

    @Insert
    void insertBeverage(Beverage beverage);


    @Update
    void updateBeverage(Beverage beverage);


    @Delete
    void deleteBeverage(Beverage beverage);


    @Query("Select * from beverages")
    List<Beverage> getAllBeverages();



}
