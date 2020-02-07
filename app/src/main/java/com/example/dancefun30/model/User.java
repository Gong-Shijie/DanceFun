package com.example.dancefun30.model;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {
    private int uid;
    private String username;
    private String email;
    private String password;
    private int journal_id;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password, int journal_id) {
        this.uid = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.journal_id = journal_id;
    }

    public int getId() {
        return uid;
    }

    public void setId(int id) {
        this.uid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(int journal_id) {
        this.journal_id = journal_id;
    }
}
