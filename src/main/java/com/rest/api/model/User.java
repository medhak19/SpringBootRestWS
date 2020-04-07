package com.rest.api.model;

public class User {

    private String firstName;
    private String lastName;


    public User(String fName,String lName){
        this.firstName=fName;
        this.lastName=lName;

    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
