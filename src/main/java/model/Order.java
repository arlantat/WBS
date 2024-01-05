package model;


import java.sql.Timestamp;


public class Order extends OrderDetail {
    private int id;
    private Acc idAcc;
    private OrderDetail idOrderDetail;
    private Shop shopzz;
    private Timestamp time;
    private boolean status;
    private double total;
    private String name;

    public Order(Product productzz, int quantity, double total, int id, Acc idAcc, OrderDetail idOrderDetail, Shop idShop, Timestamp time, boolean status, double total1) {
        super(productzz, quantity, total);
        this.id = id;
        this.idAcc = idAcc;
        this.idOrderDetail = idOrderDetail;
        this.shopzz = idShop;
        this.time = time;
        this.status = status;
        this.total = total1;
    }

    public Order(int id, Acc idAcc, OrderDetail idOrderDetail, Shop idShop, Timestamp time, boolean status) {
        this.id = id;
        this.idAcc = idAcc;
        this.idOrderDetail = idOrderDetail;
        this.shopzz = idShop;
        this.time = time;
        this.status = status;
    }

    public Order(Acc idAcc, OrderDetail idOrderDetail, Shop idShop, Timestamp time, boolean status) {
        this.idAcc = idAcc;
        this.idOrderDetail = idOrderDetail;
        this.shopzz = idShop;
        this.time = time;
        this.status = status;
    }

    public Order() {
    }

    public Order(int id, int idAcc, int idOrderDetail, java.sql.Timestamp timestamp, boolean status) {
    }

    public Order(int idAcc, int idOrderDetail, java.sql.Timestamp timestamp, boolean status) {
    }

    public Order(String name, double total) {
        this.name = name;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acc getIdAcc() {
        return idAcc;
    }

    public void setIdAcc() {
        this.idAcc = idAcc;
    }

    public OrderDetail getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(OrderDetail idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }


    public void setIdAcc(Acc idAcc) {
        this.idAcc = idAcc;
    }

    public Shop getShopzz() {
        return shopzz;
    }

    public void setShopzz(Shop shopzz) {
        this.shopzz = shopzz;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idAcc=" + idAcc +
                ", idOrderDetail=" + idOrderDetail +
                ", idShop=" + shopzz +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
