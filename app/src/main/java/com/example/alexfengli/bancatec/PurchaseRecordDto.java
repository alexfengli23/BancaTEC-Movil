package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex Feng Li on 5/7/2017.
 */

class PurchaseRecordDto {
    int ID,amount;
    String place,desc;
    Date date;

    public PurchaseRecordDto(int ID, int amount, String place, String desc, Date date) {
        this.ID = ID;
        this.amount = amount;
        this.place = place;
        this.desc = desc;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

