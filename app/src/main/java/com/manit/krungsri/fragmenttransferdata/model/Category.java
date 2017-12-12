package com.manit.krungsri.fragmenttransferdata.model;

/**
 * Created by MCNEWZ on 08-Dec-17.
 */
public class Category {
    String name;
    String id;
    String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
