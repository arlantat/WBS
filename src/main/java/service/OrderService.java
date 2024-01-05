package service;

import model.*;

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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orderaccshop");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idAcc = rs.getInt("idaccount");
                int idOrderDetail = rs.getInt("idod");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                boolean status = rs.getBoolean("status");
                orderList.add(new Order(id, idAcc, idOrderDetail, timestamp, status));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }

    public List<Order> showAll() {
        List<Order> orderList = new ArrayList<>();
        for (Order order1 : orderList) {
            System.out.println(order1);
        }
        return orderList;
    }

    @Override
    public boolean add(Order order) throws SQLException {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orderaccshop (idaccount, idorder, idshop) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, order.getIdAcc().getId());
            preparedStatement.setInt(2, order.getIdOrderDetail().getId());
            preparedStatement.setInt(3, order.getShopzz().getId());
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
    public boolean update( Order order) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE order SET idaccount=?, idod=?, idshop=?, status=? WHERE id=?");
            preparedStatement.setInt(1, order.getIdAcc().getId());
            preparedStatement.setInt(2, order.getIdOrderDetail().getId());
            preparedStatement.setInt(3, order.getShopzz().getId());
            preparedStatement.setBoolean(4, order.isStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int idOrder) throws SQLException {
        return false;
    }

    public boolean cancel(int idOrder) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update `order` set status = -1 where id = ?");
            preparedStatement.setInt(1, idOrder);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Order findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orderaccshop where id = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idAcc = rs.getInt("idaccount");
                int idOrderDetail = rs.getInt("idod");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                boolean status = rs.getBoolean("status");
                order = new Order(idAcc, idOrderDetail, timestamp, status);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    @Override
    public Order findByName(String name) {
        return null;
    }

    public boolean add(int idShop, int idAccount, double totalPrice, List<CartItem> cart) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement statement = connection.prepareStatement("insert into `order` (total) VALUES (?)");
            statement.setDouble(1, totalPrice);
            if (statement.executeUpdate() == 0) {
                connection.rollback();
                return false;
            }
            statement = connection.prepareStatement("select last_insert_id()");
            ResultSet rs = statement.executeQuery();
            int idOrder = -1;
            if (rs.next()) {
                idOrder = rs.getInt(1);
            }
            for (CartItem cartItem: cart) {
                statement = connection.prepareStatement("insert into orderdetail (idproduct, quantity, idorder) VALUES (?, ?, ?)");
                statement.setInt(1, cartItem.getId());
                statement.setInt(2, cartItem.getQuantity());
                statement.setInt(3, idOrder);
                if (statement.executeUpdate() == 0) {
                    connection.rollback();
                    return false;
                }
            }
            statement = connection.prepareStatement("insert into orderaccshop (idaccount, idorder, idshop) VALUES (?, ?, ?)");
            statement.setInt(1, idAccount);
            statement.setInt(2, idOrder);
            statement.setInt(3, idShop);
            if (statement.executeUpdate() == 0) {
                connection.rollback();
                return false;
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return true;
    }

    public List<PastOrder> ordersByAccount(int idAccount) {
        try {
            List<PastOrder> ordersByAccount = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("select idorder, idshop from orderaccshop where idaccount = ?");
            statement.setInt(1, idAccount);
            ResultSet order = statement.executeQuery();
            while (order.next()) {
                int idOrder = order.getInt("idorder");
                int idShop = order.getInt("idshop");
                statement = connection.prepareStatement("SELECT name FROM shop WHERE id = ?");
                statement.setInt(1, idShop);
                ResultSet result = statement.executeQuery();
                String nameShop = null;
                if (result.next()) {
                    nameShop = result.getString("name");
                }
                statement = connection.prepareStatement("SELECT * FROM `order` WHERE id = ?");
                statement.setInt(1, idOrder);
                result = statement.executeQuery();
                Timestamp timestamp = null;
                int status = 0;
                double total = 0;
                if (result.next()) {
                    timestamp = result.getTimestamp("timestamp");
                    status = result.getInt("status");
                    total = result.getDouble("total");
                }
                statement = connection.prepareStatement("SELECT * FROM orderdetail WHERE idorder = ?");
                statement.setInt(1, idOrder);
                result = statement.executeQuery();
                List<Product> curProducts = new ArrayList<>();
                while (result.next()) {
                    int idProduct = result.getInt("idproduct");
                    int quantity = result.getInt("quantity");
                    statement = connection.prepareStatement("SELECT name, price FROM product WHERE id = ?");
                    statement.setInt(1, idProduct);
                    result = statement.executeQuery();
                    if (result.next()) {
                        Product product = new Product(idProduct, result.getString("name"), result.getDouble("price"), quantity);
                        curProducts.add(product);
                    }
                }
                PastOrder curOrder = new PastOrder(idOrder, curProducts, nameShop, timestamp, status, total);
                ordersByAccount.add(curOrder);
            }
            return ordersByAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
