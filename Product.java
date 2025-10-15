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
    @Override
    public int getID() {
        return this.id;
    }
    @Override
    public double getPrice() {
        return this.price * count;
    }

    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count can't be less than zero");
        }
        this.count = count;
    }
}
