import java.util.ArrayList;

public class Basket implements Order {
    private ArrayList<Product> products = new ArrayList<>();
    private int id;

    public Basket(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }
    @Override
    public double getPrice() {
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product pr) {
        products.add(pr);
    }
    public boolean removeProduct(int id) {
        for (Product product : products) {
            if (product.getID() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
    public boolean incProduct(int id)
    {
        for (Product product : products) {
            if (product.getID() == id) {
                product.setCount(product.getCount() + 1);
                return true;
            }
        }
        return false;
    }
}
