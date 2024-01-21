public class Account {
    Customer owner;
    double balance;
    boolean saving;

    public Account(Customer owner, boolean type) {
        balance = 0;
        this.owner = owner;
        saving = type;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void minusBalance(double amount) {
        balance -= amount;
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
            }
            return true;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.print("Depositing $" + amount);
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    public boolean transfer(double amount, Account acc) {
        if (acc.getBalance() >= amount) {
            acc.minusBalance(amount);
            this.addBalance(amount);
            return true;
        } else {
            return false;
        }
    }
}
