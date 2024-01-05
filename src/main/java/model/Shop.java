package model;

public class Shop {
    private int id;
    private Acc azz;
    private String name;

    public Shop(int id, Acc azz , String name) {
        this.id = id;
        this.azz = azz;
        this.name = name;
    }

    public Shop( Acc azz, String name) {
        this.azz = azz;
        this.name = name;
    }

    public Shop() {
    }

    public Shop(double total) {
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
