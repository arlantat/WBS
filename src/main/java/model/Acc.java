package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Acc implements Serializable {
    private int id;
    private String loginName;
    private String hashedPassword;

    public Acc(int id, String loginName, String hashedPassword) {
        this.id = id;
        this.loginName = loginName;
        this.hashedPassword = hashedPassword;
    }

    public Acc(String loginName, String hashedPassword) {
        this.loginName = loginName;
        this.hashedPassword = hashedPassword;
    }

    public Acc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return "Acc{" +
                "loginName='" + loginName + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
