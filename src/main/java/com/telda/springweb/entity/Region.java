package com.telda.springweb.entity;


import javax.persistence.*;


@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameRegion;
    private String shortNameRegion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public String getShortNameRegion() {
        return shortNameRegion;
    }

    public void setShortNameRegion(String shortNameRegion) {
        this.shortNameRegion = shortNameRegion;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", nameRegion='" + nameRegion + '\'' +
                ", shortNameRegion='" + shortNameRegion + '\'' +
                '}';
    }

}
