package service;

import model.Acc;
import model.Order;
import model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class OrderService implements GeneralService<Order> {
    Connection connection = ConnectionCreator.getConnection();
    OrderDetail orderDetail = new OrderDetail();
    AccService accService = new AccService();
    Acc acc = new Acc();

    Order order = new Order();

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from order");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idAcc = rs.getInt("idaccount");
                int idOrderDetail = rs.getInt("idod");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                boolean status = rs.getBoolean("status");
                orderList.add(new Order(id,idAcc,idOrderDetail,timestamp,status));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }

    @Override
    public boolean add(Order order) throws SQLException {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into order (idaccount, idod, idshop,timestap,status) VALUES (?, ?, ?,?,?)");
            preparedStatement.setInt(1, order.getIdAcc().getId());
            preparedStatement.setInt(2, order.getIdOrderDetail().getId());
            preparedStatement.setInt(3, order.getIdShop().getId());
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setBoolean(5, order.isStatus());
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

    @Override
    public boolean update(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Order findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from order where id = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idAcc = rs.getInt("idaccount");
                int idOrderDetail = rs.getInt("idod");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                boolean status = rs.getBoolean("status");
                order = new Order(idAcc, idOrderDetail, timestamp,status);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    @Override
    public List<Order> findByName(String name) {
        return null;
    }
}
