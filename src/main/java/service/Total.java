package service;

import model.Order;
import model.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Total {
    ShopService shopService = new ShopService();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    Connection connection = ConnectionCreator.getConnection();
    List<Order> orders = new ArrayList<>();

    public List<Order> total() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT s.name, SUM(od.quantity * p.price) AS total_price " +
                            "FROM orderaccshop oas " +
                            "JOIN orderdetail od ON oas.idorder = od.idorder " +
                            "JOIN product p ON od.idproduct = p.id " +
                            "JOIN shop s ON oas.idshop = s.id " +
                            "GROUP BY s.name");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String shopName = rs.getString(1);
                Shop idShop = shopService.findByName(shopName);
                double total = rs.getDouble(2);
                orders.add(new Order(idShop, total));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orders;
    }
}
