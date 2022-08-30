package org.launchcode.spaday.models;

import java.time.ZonedDateTime;

public class User {
    private int id;
    private  String name;
    private  String email;
    private  String password;
    private ZonedDateTime creationDate;

    private static int nextId = 0;

    public User(String name, String email, String password){
        id = nextId++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creationDate = ZonedDateTime.now();
    }

    public int getId() {
        return id;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
