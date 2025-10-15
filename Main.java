import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создали магазин
        FileHandler fh = new FileHandler("log.txt");
        Shop shop = new Shop();
        shop.addHendler(fh);

        //Создали клиентов
        Client cl1 = new Client("Artur", 1);
        Client cl2 = new Client("Mary", 2);
        Client cl3 = new Client("Sam", 3);

        //Пополнили им счёт
        cl1.makeDeposit(1000);
        cl2.makeDeposit(300);
        cl3.makeDeposit(12000);

        //Создали товары
        Product pr1 = new Product("Blanket", 1, 2000, 1);
        Product pr2 = new Product("Slippers", 2, 250, 2);
        Product pr3 = new Product("Cardigan", 3, 3000, 1);
        Basket bsk = new Basket(1);
        bsk.addProduct(pr1);
        bsk.addProduct(pr2);

        //Зарегестрировали нескольких клиентов
        shop.signUp(cl1);
        shop.signUp(cl3);

        //Сделали несколько заказов
        shop.makeOrder(bsk, cl3.getId());
        shop.makeOrder(pr3, cl1.getId());
        shop.makeOrder(pr2, cl2.getId());
    }
}
