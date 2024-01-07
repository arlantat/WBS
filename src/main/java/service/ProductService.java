package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements GeneralService<Product> {
    Connection connection = ConnectionCreator.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                productList.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    public List<Product> findAllByShop(int idShop) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select p.id, p.name, p.price, p.imageurl, p.description " +
                            "from product p join shopproduct sp on p.id = sp.idproduct where sp.idshop = ?");
            preparedStatement.setInt(1, idShop);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String imageurl = rs.getString("imageurl");
                String description = rs.getString("description");
                Product product = new Product(id, name, price, imageurl, description);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    @Override
    public boolean add(Product product) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price,imageurl,description) values (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImageurl());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name=?, price=?,imageurl=?,description=? WHERE id=?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImageurl());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        Product productzz = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price"); // lấy ra classId từ bảng student trong db
                productzz = new Product(id, name, price);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productzz;
    }

    public List<Product> findAllByShopFiltered(int idShop, String productPattern) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select p.id, p.name, p.price, p.imageurl, p.description " +
                            "from product p join shopproduct sp on p.id = sp.idproduct where sp.idshop = ? and p.name like ?");
            preparedStatement.setInt(1, idShop);
            preparedStatement.setString(2, "%" + productPattern + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String imageurl = rs.getString("imageurl");
                String description = rs.getString("description");
                Product product = new Product(id, name, price, imageurl, description);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    public boolean addInShop(Product product,int idShop) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price,imageurl,description) values (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImageurl());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
            preparedStatement = connection.prepareStatement("select last_insert_id()");
            ResultSet rs = preparedStatement.executeQuery();
            int idProduct = -1;
            if (rs.next()) {
                idProduct = rs.getInt(1);
            }
            preparedStatement= connection.prepareStatement("insert into shopproduct(idproduct,idshop) values (?,?)");
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setInt(2, idShop);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteProduct(int id,int idShop) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from shopproduct where idshop = ? and idproduct =? ");
            preparedStatement.setInt(1, idShop);
            preparedStatement.setInt(2, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
