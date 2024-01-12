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
        System.out.println(" Account created!");
    }
}
