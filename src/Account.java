public class Account {
    Customer owner;
    int balance;
    boolean saving;
    private static int id = 0;

    public Account(Customer owner, boolean type) {
        balance = 0;
        this.owner = owner;
        saving = type;
    }
}
