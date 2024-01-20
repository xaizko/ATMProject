import java.util.ArrayList;
import java.util.List;
public class TransactionHistory {
    int idA;
    int idB;
    ArrayList<String> transactions;
    public TransactionHistory() {
        idA = 1;
        idB = 1;
        transactions = new ArrayList<>();
    }

    public void addTransaction(String actionA) {
        String temp = "";
        if (idA < 10) {
            temp = actionA + "\nTransaction ID: A000" + idA;
        } else if (idA < 100) {
            temp = actionA + "\nTransaction ID: A00" + idA;
        } else if (idA < 1000) {
            temp = actionA + "\nTransaction ID: A0" + idA;
        } else if (idA < 10000) {
            temp = actionA + "\nTransaction ID: A" + idA;
        }
        transactions.add(temp);
        idA++;
    }

    public void addTransactionB(String actionS) {
        String temp = "";
        if (idB < 10) {
            temp = actionS + "\nTransaction ID: S000" + idB;
        } else if (idB < 100) {
            temp = actionS + "\nTransaction ID: S00" + idB;
        } else if (idB < 1000) {
            temp = actionS + "\nTransaction ID: S0" + idB;
        } else if (idB < 10000) {
            temp = actionS + "\nTransaction ID: S" + idB;
        }
        transactions.add(temp);
        idB++;

    }

    public void printTransactions() {
        System.out.println("----------Transaction History----------");
        for (String action : transactions) {
            System.out.println("\n" + action + "\n");
        }
        System.out.println("---------------------------------------");
    }
}
