package exam;

public class Product {
    private String category;
    private String name;
    private float price;

    public Product(String ctgr, String name, float price) {
        this.category = ctgr;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return (this.category + ": " + this.name + " " + this.price);
    }
}
