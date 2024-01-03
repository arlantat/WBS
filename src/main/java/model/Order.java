package model;



import java.sql.Timestamp;


public class Order extends OrderDetail {
    private int id;
    private Acc idAcc;
    private OrderDetail idOrderDetail;
    private Shop idShop;
    private Timestamp time;
    private boolean status;

    public Order(int id, Acc idAcc, OrderDetail idOrderDetail, Shop idShop, Timestamp time,boolean status) {
        this.id = id;
        this.idAcc = idAcc;
        this.idOrderDetail = idOrderDetail;
        this.idShop = idShop;
        this.time = time;
        this.status = status;
    }

    public Order(Acc idAcc, OrderDetail idOrderDetail, Shop idShop, Timestamp time,boolean status) {
        this.idAcc = idAcc;
        this.idOrderDetail = idOrderDetail;
        this.idShop = idShop;
        this.time = time;
        this.status = status;
    }

    public Order() {
    }

    public Order(int id, int idAcc, int idOrderDetail, java.sql.Timestamp timestamp, boolean status) {
    }

    public Order(int idAcc, int idOrderDetail, java.sql.Timestamp timestamp, boolean status) {
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

    public void setIdAcc(Acc idAcc) {
        this.idAcc = idAcc;
    }

    public OrderDetail getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(OrderDetail idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Shop getIdShop() {
        return idShop;
    }

    public void setIdShop(Shop idShop) {
        this.idShop = idShop;
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
                ", idShop=" + idShop +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
