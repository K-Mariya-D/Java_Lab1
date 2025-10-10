public class Client {
    private String name;
    private int id;
    private double money;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }
    //пополнение счёта
    public void makeDeposit(double money) {
        this.money += money;
    }
    //снятие со счёта
    public void withdrawMoney(double money) {
        this.money -= money;
    }
    public double checkMoney() {
        return money;
    }
    public int getId() {
        return id;
    }
}
