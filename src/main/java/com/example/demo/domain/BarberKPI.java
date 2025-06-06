package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BarberKPI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String zadacha;

    private String date;
    private int narxi;
    private boolean status;

    public BarberKPI() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BarberKPI(String name, String zadacha, String date, int narxi, boolean status) {
        this.name = name;
        this.zadacha = zadacha;
        this.date = date;
        this.narxi = narxi;
        this.status=status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZadacha() {
        return zadacha;
    }

    public void setZadacha(String zadacha) {
        this.zadacha = zadacha;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNarxi() {
        return narxi;
    }

    public void setNarxi(int narxi) {
        this.narxi = narxi;
    }
}
