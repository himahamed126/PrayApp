package com.example.prayapp.data.local.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prayTable")
public class Prays {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String day;
    private boolean fajr, zohr, asr, maghrb, asha;
    @ColumnInfo(name = "total")
    private double percent;

    public Prays(String day, boolean fajr, boolean zohr, boolean asr, boolean maghrb, boolean asha, double percent) {
        this.day = day;
        this.fajr = fajr;
        this.zohr = zohr;
        this.asr = asr;
        this.maghrb = maghrb;
        this.asha = asha;
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isFajr() {
        return fajr;
    }

    public void setFajr(boolean fajr) {
        this.fajr = fajr;
    }

    public boolean isZohr() {
        return zohr;
    }

    public void setZohr(boolean zohr) {
        this.zohr = zohr;
    }

    public boolean isAsr() {
        return asr;
    }

    public void setAsr(boolean asr) {
        this.asr = asr;
    }

    public boolean isMaghrb() {
        return maghrb;
    }

    public void setMaghrb(boolean maghrb) {
        this.maghrb = maghrb;
    }

    public boolean isAsha() {
        return asha;
    }

    public void setAsha(boolean asha) {
        this.asha = asha;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
