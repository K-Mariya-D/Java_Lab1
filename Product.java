public class Product implements Order {
    private String name;
    private int id;
    private double price;
    private int count;

    public Product(String name, int id, double price, int count) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getID() {
        return this.id;
    }
    @Override
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        assert (price > 0);
        this.price = price;
    }
    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        assert (count > 0);
        this.count = count;
    }
}
