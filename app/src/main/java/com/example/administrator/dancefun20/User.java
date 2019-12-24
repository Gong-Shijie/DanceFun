package com.example.administrator.dancefun20;
import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String username;
    private String email;
    private String password;
    private int journal_id;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(String username, String email, String password, int journal_id) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.journal_id = journal_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(int journal_id) {
        this.journal_id = journal_id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email="
                + email + ",password =" + password + ", journal_ids=" + journal_id + "]";
    }



}

