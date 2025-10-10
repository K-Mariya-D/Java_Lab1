import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Client> clients = new ArrayList<>();

    private class Logger {}

    public void signUp(Client client) {
        clients.add(client);
    }

    //id - идентификатор клиента, совершающего покупку
    public boolean makeOrder(Order order, int id) {
        Client client = null;
        for (Client c : clients) {
            if (c.getId() == id) {
                client = c;
                break;
            }
        }
        //Проверка, что такой клиент нашёлся, иначе предложение зарегаться
        if (client == null) {
            System.out.println("Зарегестрируйтесь, прежде чем сделать заказ.");
            return false;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите куда доставить заказ: ");
        String adress = sc.nextLine();

        double price = order.getPrice();
        if (client.checkMoney() >= price) {
            client.withdrawMoney(price);
            System.out.println("Заказ передан в службу доставки!");
            return true;
        }
        else {
            System.out.println("На счёте не достаточно средств!");
            return false;
        }
    }

}
