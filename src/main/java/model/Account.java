package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account implements Serializable {
    private String loginName;
    private String hashedPassword;

    public Account(String loginName, String password, boolean hashed) {
        this.loginName = loginName;
        if (!hashed) {
            this.hashedPassword = hashPassword(password);
        } else {
            this.hashedPassword = password;
        }
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String newLoginName) {
        this.loginName = newLoginName;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String newPassword) {
        this.hashedPassword = hashPassword(newPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean verifyLogin(String password) {
        String storedPassword = this.hashedPassword;
        if (storedPassword != null) {
            String encodedPassword = hashPassword(password);
            return storedPassword.equals(encodedPassword);
        }
        return false;
    }
}
