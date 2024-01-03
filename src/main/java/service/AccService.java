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
                String name = rs.getString("name");
                String password = rs.getString("password");
                accList.add(new Acc(name, password));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accList;
    }

    @Override
    public boolean add(Acc acc) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account(name, password) values (?,?)");
            preparedStatement.setString(1, acc.getLoginName());
            preparedStatement.setString(2, acc.getHashedPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(Acc acc) throws SQLException {
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
                String name = rs.getString("name");
                String password = rs.getString("password"); // lấy ra classId từ bảng student trong db
                acc = new Acc(name, password);
            }
        } catch (SQLException e) {
        }
        return acc;
    }

    @Override
    public List<Acc> findByName(String name) {
        return null;
    }
}
