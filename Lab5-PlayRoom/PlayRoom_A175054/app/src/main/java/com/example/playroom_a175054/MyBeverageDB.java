package com.example.playroom_a175054;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.playroom_a175054.dao.BeverageDao;
import com.example.playroom_a175054.entities.Beverage;

@Database(entities = {Beverage.class},version = 1)
public abstract class MyBeverageDB extends RoomDatabase {

        public abstract BeverageDao beverageDao();





}
