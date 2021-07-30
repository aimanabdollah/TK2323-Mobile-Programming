package com.example.playroom_a175054.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "beverages")
public class Beverage {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "beverage_id")
    int beverageID;

    @NonNull
    @ColumnInfo(name = "beverage_name")
    String beverageName;

    @NonNull
    @ColumnInfo(name = "beverage_price")
    float beveragePrice;

    public Beverage(@NonNull int beverageID) {
        this.beverageID = beverageID;
    }

    public Beverage(@NonNull String beverageName, @NonNull float beveragePrice) {
        this.beverageName = beverageName;
        this.beveragePrice = beveragePrice;
    }

    public Beverage(@NonNull int beverageID, @NonNull String beverageName, @NonNull float beveragePrice) {
        this.beverageID = beverageID;
        this.beverageName = beverageName;
        this.beveragePrice = beveragePrice;
    }

    public Beverage() {

    }

    public int getBeverageID() {
        return beverageID;
    }

    public void setBeverageID(int beverageID) {
        this.beverageID = beverageID;
    }

    @NonNull
    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(@NonNull String beverageName) {
        this.beverageName = beverageName;
    }

    public float getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(float beveragePrice) {
        this.beveragePrice = beveragePrice;
    }
}
