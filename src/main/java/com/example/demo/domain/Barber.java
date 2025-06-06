package com.example.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bar")
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idd;
    private String name;
    private String number;
    private String age;
    private String login;
    private String password;
    private  String role;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "barber_role", joinColumns = @JoinColumn(name = "barber_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Barber() {
    }


    public Barber(String name, String number, String age, String login, String password, String role) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role=role;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public long getId() {
        return idd;
    }

    public void setId(long id) {
        this.idd = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
