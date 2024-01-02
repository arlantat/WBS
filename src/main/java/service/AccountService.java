package service;

import model.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "admin");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from account");) {
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                accounts.add(new Account(username, password, true));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean add(Account newAccount) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO account (username, password) VALUES (?, ?)");) {
            preparedStatement.setString(1, newAccount.getLoginName());
            preparedStatement.setString(2, newAccount.getHashedPassword());
            System.out.println(preparedStatement); //in ra câu truy vấn.
            int rowsAffected = preparedStatement.executeUpdate();
            boolean successful = rowsAffected > 0;
            System.out.println(successful);
            return successful;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public boolean verifyLogin(String username, String plainPassword) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select password from account where username = ?");) {
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (hashPassword(plainPassword).equals(hashedPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public Actor findById(int id) {
//        Actor actor = new Actor();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("select * from actor where actor_id = ?");) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement); //in ra câu truy vấn.
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int actorId = rs.getInt("actor_id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                actor.setId(actorId);
//                actor.setFirstName(firstName);
//                actor.setLastName(lastName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return actor;
//    }
//
//    @Override
//    public List<Actor> filter(Actor aActor) throws SQLException {
//        List<Actor> filteredActors = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("select * from actor where first_name like ? and last_name like ?");) {
//            preparedStatement.setString(1, "%" + aActor.getFirstName() + "%");
//            preparedStatement.setString(2, "%" + aActor.getLastName() + "%");
//            System.out.println(preparedStatement); //in ra câu truy vấn.
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int actorId = rs.getInt("actor_id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                Actor actor = new Actor(actorId, firstName, lastName);
//                filteredActors.add(actor);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return filteredActors;
//    }
//
//    @Override
//    public boolean delete(int id) throws SQLException {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM actor WHERE actor_id = ?");) {
//            connection.setAutoCommit(false);
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement); // Display query statement
//            int rowsAffected = preparedStatement.executeUpdate();
//            boolean successful = rowsAffected > 0;
//            System.out.println(successful);
//            connection.rollback();
//            return successful;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean modify(int id, Actor aActor, Timestamp timestamp) throws SQLException {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE actor\n" +
//                     "SET first_name = ?, last_name = ?, last_update = ?\n" +
//                     "WHERE actor_id = ?");) {
//            connection.setAutoCommit(false);
//            preparedStatement.setString(1, aActor.getFirstName());
//            preparedStatement.setString(2, aActor.getLastName());
//            preparedStatement.setTimestamp(3, timestamp);
//            preparedStatement.setInt(4, aActor.getId());
//            System.out.println(preparedStatement); //in ra câu truy vấn.
//            int rowsAffected = preparedStatement.executeUpdate();
//            boolean successful = rowsAffected > 0;
//            connection.rollback();
//            return successful;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

}
