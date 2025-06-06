package com.example.demo.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Massage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    private String username;
    private String barbername;
    private String still;
    private String date;
    private String time;
    private String number;
    private String message;



    private boolean status;
    public Massage() {
    }
    public Massage(boolean status) {
        this.status=status;
    }
    public Massage(String username,
                   String barbername,
                   String still,
                   String date,
                   String time,
                   String number,
                   String message,
                   boolean status)
    {

        this.username = username;
        this.barbername = barbername;
        this.still = still;
        this.date = date;
        this.time = time;
        this.number = number;
        this.message = message;
        this.status=status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBarbername() {
        return barbername;
    }

    public void setBarbername(String barbername) {
        this.barbername = barbername;
    }

    public String getStill() {
        return still;
    }

    public void setStill(String still) {
        this.still = still;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
