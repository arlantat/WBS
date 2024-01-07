package service;

import model.Total;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TotalService {
    ShopService shopService = new ShopService();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    Connection connection = ConnectionCreator.getConnection();
    List<Total> totalList = new ArrayList<>();

    public List<Total> total() {
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
                double total = rs.getDouble(2);
                totalList.add(new Total(shopName, total));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return totalList;
    }

}
