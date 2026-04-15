public class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {this.balance = initialBalance;}
    public synchronized void deposit(double amount) {balance += amount;}
    public double getBalance() {return balance;}
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Số dư không đủ để rút.");
        }
    }
}
