import java.io.Console;
import java.util.Scanner;
public class ATM {
    Scanner scan;
    Customer customer;
    Account saving;
    Account checking;
    TransactionHistory history;

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
            System.out.println(ConsoleUtility.RED + "Not a valid pin! Try again." + ConsoleUtility.RESET);
            scan.nextLine();
            System.out.print("Enter a pin: ");
            scan.nextInt();
        }

        //object creation
        System.out.print("Creating account");
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }

        }
        customer = new Customer(name, pin);
        saving = new Account(customer, true);
        checking = new Account(customer, false);
        history =  new TransactionHistory();
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
                    System.out.println(ConsoleUtility.RED + "Not a valid option, try again!" + ConsoleUtility.RESET);
                    input = scan.nextInt();
                }
            } catch (Exception e) {
                System.out.println(ConsoleUtility.RED + "That is not an option, try again!" + ConsoleUtility.RESET);
                scan.nextLine();
                input = scan.nextInt();
            }

            //withdraw
            if (input == 1) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("Please enter 1 for checking and 2 for savings: ");
                    acc = scan.nextInt();
                    if (acc == 1) {
                        System.out.print("How much would you like to withdraw? (Please enter amount dispensable in 5's and 20's): ");
                        int amount = scan.nextInt();
                        if (((amount % 5) == 0)){
                            if (checking.withdraw(amount)) {
                                history.addTransaction(ConsoleUtility.GREEN + "Withdraw of $" + amount + ": successful\nBalance: $" + checking.getBalance() + ConsoleUtility.RESET);
                                System.out.println("\n\n-----Receipt-----");
                                System.out.println(ConsoleUtility.GREEN + "Withdrawal of $" + amount + " successful!\nCurrent balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                                System.out.println(history.getID());
                                System.out.println("-----------------\n");
                            } else {
                                history.addTransaction(ConsoleUtility.RED + "Withdraw of $" + amount + ": unsuccessful\nBalance: $" + checking.getBalance() + ConsoleUtility.RESET);
                                System.out.println("\n\n-----Receipt-----");
                                System.out.println("Withdrawal of $" + amount + " unsuccessful\nCurrent balance: $" + checking.getBalance());
                                System.out.println(history.getID());
                                System.out.println("-----------------\n");
                            }
                        } else {
                            System.out.println(ConsoleUtility.RED + "Error: Indispensable Amount\nTransaction Failed\n" + ConsoleUtility.RESET);
                            history.addTransaction(ConsoleUtility.RED + "Withdraw of $" + amount + ": unsuccessful\nBalance: $" + checking.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println("Withdrawal of $" + amount + " unsuccessful\nCurrent balance: $" + checking.getBalance());
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        }
                    } else if (acc == 2) {
                        System.out.println("How much would you like to withdraw? (Please enter amount dispensable in 5's and 20's)");
                        int amount = scan.nextInt();
                        if (((amount % 5) == 0)){
                            if (saving.withdraw(amount)) {
                                history.addTransaction(ConsoleUtility.GREEN + "Withdraw of $" + amount + ": successful\nBalance: $" + saving.getBalance() + ConsoleUtility.RESET);
                                System.out.println("\n\n-----Receipt-----");
                                System.out.println(ConsoleUtility.GREEN + "Withdrawal of $" + amount + " successful!\nCurrent balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                                System.out.println(history.getID());
                                System.out.println("-----------------\n");
                            } else {
                                history.addTransaction(ConsoleUtility.RED + "Withdraw of $" + amount + ": unsuccessful\nBalance: $" + saving.getBalance() + ConsoleUtility.RESET);
                                System.out.println("\n\n-----Receipt-----");
                                System.out.println(ConsoleUtility.RED + "Withdrawal of $" + amount + " unsuccessful\nCurrent balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                                System.out.println(history.getID());
                                System.out.println("-----------------\n");
                            }
                        } else {
                            System.out.println(ConsoleUtility.RED + "Error: Indispensable Amount\nTransaction Failed\n" + ConsoleUtility.RESET);
                            history.addTransaction(ConsoleUtility.RED + "Withdraw of $" + amount + ": unsuccessful\nBalance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println(ConsoleUtility.RED + "Withdrawal of $" + amount + " unsuccessful\nCurrent balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        }
                    } else {
                        System.out.println(ConsoleUtility.RED + "Error: Invalid Choice\nTransaction failed\n" + ConsoleUtility.RESET);
                    }
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            // deposit
            else if (input == 2) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("Enter 1 to deposit into checking, enter 2 to deposit into savings: ");
                    try {
                        acc = scan.nextInt();
                        if (acc < 1 || acc > 2) {
                            System.out.println(ConsoleUtility.RED + "Not a valid option, try again!" + ConsoleUtility.RESET);
                            acc = scan.nextInt();
                        }
                    } catch (Exception e) {
                        System.out.println(ConsoleUtility.RED + "That is not an option, try again!" + ConsoleUtility.RESET);
                        scan.nextLine();
                        acc = scan.nextInt();
                    }
                    System.out.print("Enter your deposit amount: ");
                    double dep = scan.nextDouble();
                    if (acc == 1) {
                        checking.deposit(dep);
                        history.addTransaction(ConsoleUtility.GREEN + "Deposit of $" + dep + ": successful\nBalance: $" + checking.getBalance() + ConsoleUtility.RESET);
                        System.out.println("\n\n-----Receipt-----");
                        System.out.println(ConsoleUtility.GREEN + "Deposit of $" + dep + " successful!\nCurrent balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                        System.out.println(history.getID());
                        System.out.println("-----------------\n");
                    } else if (acc == 2) {
                        saving.deposit(dep);
                        history.addTransaction(ConsoleUtility.GREEN + "Deposit of $" + dep + ": successful\nBalance: $" + saving.getBalance() + ConsoleUtility.RESET);
                        System.out.println("\n\n-----Receipt-----");
                        System.out.println(ConsoleUtility.GREEN + "Deposit of $" + dep + " successful!\nCurrent balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                        System.out.println(history.getID());
                        System.out.println("-----------------\n");
                    }
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            //transferring
            else if (input == 3) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("Enter 1 to transfer funds into checking, enter 2 to transfer funds into savings: ");
                    try {
                        acc = scan.nextInt();
                        if (acc < 1 || acc > 2) {
                            System.out.println(ConsoleUtility.RED + "Not a valid option, try again!"  + ConsoleUtility.RESET);
                            acc = scan.nextInt();
                        }
                    } catch (Exception e) {
                        System.out.println(ConsoleUtility.RED + "That is not an option, try again!" + ConsoleUtility.RESET);
                        scan.nextLine();
                        acc = scan.nextInt();
                    }
                    System.out.print("Enter your transfer amount: ");
                    double transferAmount = scan.nextDouble();
                    if  (acc == 1) {
                        if (checking.transfer(transferAmount, saving)) {
                            history.addTransaction(ConsoleUtility.GREEN + "Transfer of $" + transferAmount + ": successful\nChecking balance: $" + checking.getBalance() + "\nSavings balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println(ConsoleUtility.GREEN + "Transfer of $" + transferAmount + " successful!\nChecking balance: $" + checking.getBalance() + "\nSavings balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        } else {
                            history.addTransaction(ConsoleUtility.RED + "Transfer of $" + transferAmount + ": unsuccessful\nChecking balance: $" + checking.getBalance() + "\nSavings balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println(ConsoleUtility.RED + "Transfer of $" + transferAmount + " unsuccessful!\nChecking balance: $" + checking.getBalance() + "\nSavings balance: $" + saving.getBalance() + ConsoleUtility.RESET);
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        }
                    } else if (acc == 2) {
                        if (saving.transfer(transferAmount, checking)) {
                            history.addTransaction(ConsoleUtility.GREEN + "Transfer of $" + transferAmount + ": successful\nSavings balance: $" + saving.getBalance() + "\nChecking balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println(ConsoleUtility.GREEN + "Transfer of $" + transferAmount + " successful!\nSavings balance: $" + saving.getBalance() + "\nChecking balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        } else {
                            history.addTransaction(ConsoleUtility.RED + "Transfer of $" + transferAmount + ": unsuccessful\nSavings balance: $" + saving.getBalance() + "\nChecking balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                            System.out.println("\n\n-----Receipt-----");
                            System.out.println(ConsoleUtility.RED + "Transfer of $" + transferAmount + " unsuccessful!\nSavings balance: $" + saving.getBalance() + "\nChecking balance: $" + checking.getBalance() + ConsoleUtility.RESET);
                            System.out.println(history.getID());
                            System.out.println("-----------------\n");
                        }
                    }
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            //get balance
            else if (input == 4) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("\nRetrieving balances");
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                    }
                    System.out.println("\nChecking balance: " + ConsoleUtility.GREEN + "$" + checking.getBalance() + ConsoleUtility.RESET);
                    System.out.println("Savings balance: " + ConsoleUtility.GREEN + "$" + saving.getBalance() + ConsoleUtility.RESET);
                    history.addTransactionB("Retrieved Balances: Successful");
                    System.out.println("\n\n-----Receipt-----");
                    System.out.println(ConsoleUtility.GREEN + "Retrieved Balances: Successful" + ConsoleUtility.RESET);
                    System.out.println(history.getID());
                    System.out.println("-----------------\n");
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            // print history
            else if (input == 5) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("\nRetrieving transaction history");
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                    }
                    System.out.println();
                    history.addTransactionB(ConsoleUtility.GREEN + "Retrieved Transaction History: Successful" + ConsoleUtility.RESET);
                    history.printTransactions();
                    System.out.println("\n\n-----Receipt-----");
                    System.out.println(ConsoleUtility.GREEN + "Retrieved Transaction History: Successful" + ConsoleUtility.RESET);
                    System.out.println(history.getID());
                    System.out.println("-----------------\n");
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            //change pin
            else if (input == 6) {
                System.out.print("\nPlease enter your pin: ");
                int temp = scan.nextInt();
                if (temp == customer.getPin()) {
                    System.out.print("Enter your new pin: ");
                    int newPin = scan.nextInt();
                    customer.setPin(newPin);
                    System.out.print("\nChanging");
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                    }
                    history.addTransactionB(ConsoleUtility.GREEN + "Changed Pin: Successful" + ConsoleUtility.RESET);
                    System.out.println("\n\n-----Receipt-----");
                    System.out.println(ConsoleUtility.GREEN + "Changed Pin: Successful" + ConsoleUtility.RESET);
                    System.out.println(history.getID());
                    System.out.println("-----------------\n");
                } else {
                    System.out.println(ConsoleUtility.RED + "Error: Incorrect Pin\n" + ConsoleUtility.RESET);
                }
            }

            System.out.println("Thank you for using the ATM, come again!`");

        }
    }
}
