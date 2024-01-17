import java.util.Scanner;
public class ATM {
    Scanner scan;
    Customer customer;
    Account saving;
    Account checking;
    public ATM() {
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM! Please enter a name and pin.");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Pin: ");
        int pin = scan.nextInt();

        //object creation
        System.out.print("Creating account");
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);  // 2000 milliseconds, or 2 seconds
            } catch (Exception e) {
                System.out.println("error");
            }

        }
        customer = new Customer(name, pin);
        saving = new Account(customer, true);
        checking = new Account(customer, false);
        System.out.println(" Account created!\n");

        //menu
        int input = 0;
        while (input != 7) {
            System.out.print("What action would you like to preform?\n" +
                    "1. Withdraw money\n" +
                    "2. Deposit money\n" +
                    "3. Transfer money between accounts\n" +
                    "4. Get account balances\n" +
                    "5. Get transaction history\n" +
                    "6. Change PIN\n" +
                    "7. Exit\n");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("That is not an option, try again!");
                scan.nextLine();
            }
        }
    }
}
