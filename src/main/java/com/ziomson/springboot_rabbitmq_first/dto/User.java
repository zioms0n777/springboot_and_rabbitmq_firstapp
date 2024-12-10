package com.ziomson.springboot_rabbitmq_first.dto;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String firstName;
    private String lastName;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Override toString method for proper logging
    @Override
    public String toString() {
        return String.format("User{id=%d, firstName='%s', lastName='%s'}", id, firstName, lastName);
    }
}