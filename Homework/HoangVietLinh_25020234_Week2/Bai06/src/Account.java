import java.util.Arrays;

public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int count = 0;
    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[20];
    }
    public String getAccountId() {
        return accountId;
    }
    public double getBalance() {
        return balance;
    }
    public Transaction[] getHistory() {
        return Arrays.copyOf(history, count);
    }
    public void addTransaction(Transaction transaction) {
        this.balance += transaction.getAmonut();
        if (count < history.length) {
            history[count++] = transaction;
        }
    }
}
