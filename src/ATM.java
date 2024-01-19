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
        int pin = 0;

        try {
            pin = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Not a valid pin! Try again.");
            scan.nextLine();
            System.out.print("Enter a pin: ");
            scan.nextInt();
        }

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
            int acc = 0;
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
                if (input < 1 || input > 7) {
                    System.out.println("Not a valid option, try again!");
                    input = scan.nextInt();
                }
            } catch (Exception e) {
                System.out.println("That is not an option, try again!");
                scan.nextLine();
                input = scan.nextInt();
            }

            //choice
            if (input == 1) {
                System.out.print("Please enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("Please enter 1 for checking and 2 for savings: ");
                    acc = scan.nextInt();
                    if (acc == 1) {
                        System.out.println("How much would you like to withdraw? (Please enter amount dispensable in 5's and 20's)");
                        int amount = scan.nextInt();
                        if (((amount % 5) == 0)){
                            checking.withdraw(amount);
                        } else {
                            System.out.println("Error: Indispensable Amount\nTransaction Failed");
                        }
                    } else if (acc == 2) {
                        System.out.println("How much would you like to withdraw? (Please enter amount dispensable in 5's and 20's)");
                        int amount = scan.nextInt();
                        if (((amount % 5) == 0)){
                            saving.withdraw(amount);
                        } else {
                            System.out.println("Error: Indispensable Amount\nTransaction Failed");
                        }
                    } else {
                        System.out.println("Error: Invalid Choice\nTransaction failed");
                    }
                }
            }
        }
    }
}
