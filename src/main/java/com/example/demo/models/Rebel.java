package com.example.demo.models;


import java.util.Date;

public class Rebel {
    private String name;
    private String planet;
    private Date datetime;

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getName() {
        return name;
    }

    public String getPlanet() {
        return planet;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Rebel(String name, String planet) {
        this.name = name;
        this.planet = planet;
        this.datetime = new Date();
    }

    public String generarFrase() {
        return "rebel " + this.getName() + " on " + this.getPlanet() + " at " + this.getDatetime();
    }
}
