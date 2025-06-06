package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Helper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int nitral;

    public Helper() {
    }

    public Helper(int nitral) {
        this.nitral = nitral;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNitral() {
        return nitral;
    }

    public void setNitral(int nitral) {
        this.nitral = nitral;
    }
}
