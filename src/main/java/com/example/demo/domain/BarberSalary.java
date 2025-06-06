package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BarberSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long zavafkaid;
    private String username;
    private String barbername;
    private String still;
    private String date;
    private String time;
    private String number;
    private String message;
    private long  salary;
    private boolean status;

    public BarberSalary( ) {
    }
    public BarberSalary( int salary) {
        this.salary=salary;
    }


    public BarberSalary(long zavafkaid,
                        String username,
                        String barbername,
                        String still,
                        String date,
                        String time,
                        String number,
                        String message,
                        boolean status,
                        long salary) {
        this.zavafkaid = zavafkaid;
        this.username = username;
        this.barbername = barbername;
        this.still = still;
        this.date = date;
        this.time = time;
        this.number = number;
        this.message = message;
        this.status=status;
        this.salary=salary;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getZavafkaid() {
        return zavafkaid;
    }

    public void setZavafkaid(int zavafkaid) {
        this.zavafkaid = zavafkaid;
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
