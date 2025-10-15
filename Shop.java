import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class Shop {
    private ArrayList<Client> clients = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Shop.class.getName());

    public void addHendler(Handler h) {
        logger.addHandler(h);
        logger.setLevel(Level.ALL);
        logger.info("Add another handler");
    }

    //Внутренний класс исключения
    private static class UnknownClientException extends Exception {
        public UnknownClientException(String message) {
            super(message);
        }
    }
    private Client findClient(int id) throws UnknownClientException {
        assert (id > 0): "Invalid id";
        for (Client c : clients) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new UnknownClientException("id = " + id);
    }

    public void signUp(Client client) {
        clients.add(client);
        logger.info("Client with id = {%d} was registered".formatted(client.getId()));
    }

    //id - идентификатор клиента, совершающего покупку
    public boolean makeOrder(Order order, int id) {

        Client client;
        try {
            client = findClient(id);
        } catch (UnknownClientException ex) {
            logger.log(Level.WARNING, "Exception: ", ex);
            System.out.println("Зарегестрируйтесь, прежде чем сделать заказ.");
            return false;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите куда доставить заказ: ");
        String adress = sc.nextLine();

        double price = order.getPrice();
        try {
            client.withdrawMoney(price);
        }
        catch (IllegalArgumentException ex) {
            logger.log(Level.WARNING, "Exception:", ex);
            System.out.println("На счёте не достаточно средств!");
            return false;
        }

        System.out.println("Заказ передан в службу доставки!");
        logger.fine("Order is made");
        return true;
    }
}
