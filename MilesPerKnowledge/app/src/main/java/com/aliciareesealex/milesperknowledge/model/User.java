package com.aliciareesealex.milesperknowledge.model;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */

import com.aliciareesealex.milesperknowledge.Contract;

public class User implements Contract.MPKModel.UserModel {
    private String firstName;
    private String lastName;
    private String Username;
    private int userID;

    public User() {
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
