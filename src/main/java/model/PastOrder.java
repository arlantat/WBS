package model;



import java.sql.Timestamp;
import java.util.List;


public class PastOrder {
    private int id;
    private List<Product> productList;
    private String nameShop;
    private Timestamp timestamp;
    private int status;
    private double total;

    public PastOrder(int id, List<Product> productList, String nameShop, Timestamp timestamp, int status, double total) {
        this.id = id;
        this.productList = productList;
        this.nameShop = nameShop;
        this.timestamp = timestamp;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getNameShop() {
        return nameShop;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productList=" + productList +
                ", nameShop='" + nameShop + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
