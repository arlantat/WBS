package service;

import model.Acc;
import model.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopService implements GeneralService<Shop> {
    Connection connection = ConnectionCreator.getConnection();

    @Override
    public List<Shop> findAll() {
        List<Shop> shops = new ArrayList<>();
        try {
            AccService accService = new AccService();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shop");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int idAcc = rs.getInt("idaccount");
                Acc aac = accService.findById(idAcc);
                shops.add(new Shop(id, name, aac));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return shops;
    }

    @Override
    public boolean add(Shop shop) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into shop(idaccount, name) values (?,?)");
            preparedStatement.setInt(1, shop.getAzz().getId());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(Shop shop) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Shop findById(int id) {
        Shop shop = new Shop();
        AccService accService = new AccService();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from shop where id=?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int idAcc = rs.getInt("idaccount");
                Acc acz = accService.findById(idAcc);
                shop = (new Shop(id, name, acz));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return shop;
    }

    @Override
    public List<Shop> findByName(String name) {
        return null;
    }
}