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
                int idAcc = rs.getInt("idaccount");
                String name = rs.getString("name");
                Acc aac = accService.findById(idAcc);
                shops.add(new Shop(aac, name));
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET idaccount=?, name=? WHERE id=?");
            preparedStatement.setInt(1, shop.getAzz().getId());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                int idAcc = rs.getInt("idaccount");
                String name = rs.getString("name");
                Acc acz = accService.findById(idAcc);
                shop = (new Shop(acz, name));
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
