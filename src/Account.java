public class Account {
    Customer owner;
    int balance;
    boolean saving;
    private static int id = 0;

    public Account(Customer owner, boolean type) {
        balance = 500;
        this.owner = owner;
        saving = type;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient Funds\nWithdraw Unsuccessful\n");
        } else {
            int twenty = amount / 20;
            if (amount % 20 == 0) {
                System.out.print("Withdrawing " + twenty + " twenty's");
                for (int i = 1; i <= 3; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(1000);  // 2000 milliseconds, or 2 seconds
                    } catch (Exception e) {
                        System.out.println("error");
                    }

                }
                System.out.println("\nWithdraw Successful!\n");
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
                System.out.println("\nWithdraw Successful!\n");
            }
        }
    }
}
