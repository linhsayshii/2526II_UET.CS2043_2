public class Transaction {
    private final String transactionId;
    private final double amount;
    private final String timestamp;
    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public double getAmonut() {
        return amount;
    }
    @Override
    public String toString() {
        return "{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
