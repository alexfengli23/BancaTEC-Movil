package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public class MovementHistoryDto {
    int id,amount;
    Date date;
    String operation,description,place;

    public MovementHistoryDto(int id, int amount, Date date, String operation, String description, String place) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.operation = operation;
        this.description = description;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
