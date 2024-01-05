package model;

public class Total {
    private String name;
    private double total;

    public Total(String name, double total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Total{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
