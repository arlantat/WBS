package model;

public class Shop {
    private int id;
    private String name;
    private Acc azz;

    public Shop(int id, String name, Acc azz) {
        this.id = id;
        this.name = name;
        this.azz = azz;
    }

    public Shop(String name, Acc azz) {
        this.name = name;
        this.azz = azz;
    }

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Acc getAzz() {
        return azz;
    }

    public void setAzz(Acc azz) {
        this.azz = azz;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", azz=" + azz +
                '}';
    }
}
