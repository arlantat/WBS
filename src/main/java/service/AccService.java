package service;

import model.Acc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccService implements GeneralService<Acc> {
    Connection connection = ConnectionCreator.getConnection();

    @Override
    public List<Acc> findAll() {
        List<Acc> accList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                accList.add(new Acc(id, username, password));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accList;
    }

    public List<Acc> filter(String usernamePattern) {
        List<Acc> accList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account where username like ?");
            preparedStatement.setString(1, "%" + usernamePattern + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                accList.add(new Acc(id, username, password));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accList;
    }

    @Override
    public boolean add(Acc acc) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account (username, password) values (?,?)");
            preparedStatement.setString(1, acc.getUsername());
            preparedStatement.setString(2, acc.getPassword());
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(Acc acc) {
        return false;
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET password = ? WHERE username = ? and password = ?");
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, currentPassword);
            preparedStatement.setString(1, newPassword);
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Acc findById(int id) {
        Acc acc = new Acc();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account where id = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password"); // lấy ra classId từ bảng student trong db
                acc = new Acc(username, password);
            }
        } catch (SQLException e) {
        }
        return acc;
    }

    public boolean verify(Acc acc) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from account where username = ? and password = ?");
            preparedStatement.setString(1, acc.getUsername());
            preparedStatement.setString(2, acc.getPassword());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
        }
        return false;
    }

    public int findByName(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id from account where username = ?");
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
        }
        return -1;
    }
}
