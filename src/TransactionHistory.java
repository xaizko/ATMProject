import java.util.ArrayList;
import java.util.List;
public class TransactionHistory {
    int idA;
    int idB;
    ArrayList<String> transactions;
    public TransactionHistory() {
        idA = 0;
        idB = 0;
        transactions = new ArrayList<>();
    }

    public void addTransaction(String actionA) {
        transactions.add(actionA);
        idA++;
    }

    public void addTransactionB(String actionS) {
        transactions.add(actionS);
        idB++;
    }
}
