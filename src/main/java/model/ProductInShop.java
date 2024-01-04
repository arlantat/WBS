package model;

public class ProductInShop {
    private int id;
    private Product idProduct;
    private Shop idShop;
    private int stock;

    public ProductInShop(int id, Product idProduct, Shop idShop, int stock) {
        this.id = id;
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.stock = stock;
    }

    public ProductInShop(Product idProduct, Shop idShop, int stock) {
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.stock = stock;
    }

    public ProductInShop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Shop getIdShop() {
        return idShop;
    }

    public void setIdShop(Shop idShop) {
        this.idShop = idShop;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductInShop{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idShop=" + idShop +
                ", Stock=" + this.stock +
                '}';
    }
}
