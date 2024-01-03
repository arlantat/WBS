package model;

public class OrderDetail {
    private int id;
    private Product productzz;
    private int quantity;
    private double total;

    public OrderDetail(int id, Product productzz, int quantity, double total) {
        this.id = id;
        this.productzz = productzz;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderDetail(Product productzz, int quantity, double total) {
        this.productzz = productzz;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProductzz() {
        return productzz;
    }

    public void setProductzz(Product productzz) {
        this.productzz = productzz;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", productzz=" + productzz +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
