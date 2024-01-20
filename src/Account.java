public class Account {
    Customer owner;
    double balance;
    boolean saving;
    private static int id = 0;

    public Account(Customer owner, boolean type) {
        balance = 500;
        this.owner = owner;
        saving = type;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient Funds\nWithdraw Unsuccessful\n");
            return false;
        } else {
            int twenty = amount / 20;
            if (amount % 20 == 0) {
                System.out.print("Withdrawing " + twenty + " twenty's");
                for (int i = 1; i <= 3; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("error");
                    }

                }
                balance -= amount;
                System.out.println("\n\n-----Receipt-----");
                System.out.println("Withdrawal of $" + amount + " successful!\nCurrent balance: $"+ balance);
                System.out.println("-----------------\n");
            } else {
                int five = (amount - (twenty * 20)) / 5;
                System.out.print("Withdrawing " + twenty + " twenty's and " + five+ " five's");
                for (int i = 1; i <= 3; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);  // 2000 milliseconds, or 2 seconds
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
                balance -= amount;
                System.out.println("\n\n-----Receipt-----");
                System.out.println("Withdrawal of $" + amount + " successful!\nCurrent balance: $" + balance);
                System.out.println("-----------------\n");
            }
            return true;
        }
    }
}
