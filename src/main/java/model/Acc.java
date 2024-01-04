package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Acc implements Serializable {
    private int id;
    private String username;
    private String password;

    public Acc(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Acc(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Acc() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Acc{" +
                "loginName='" + username + '\'' +
                ", hashedPassword='" + password + '\'' +
                '}';
    }
}
