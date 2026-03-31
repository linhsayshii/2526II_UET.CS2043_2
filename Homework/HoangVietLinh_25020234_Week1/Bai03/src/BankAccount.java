package src;
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance = 0.0;
    //Trạng thái của tài khoản (accountNumber, ownerName, balance)

    public void openAccount(String accNum, String owner) {  //Hành vi mở tài khoản
        this.accountNumber = accNum;
        this.ownerName = owner;
    }

    public void deposit(double amount) {    //Hành vi nạp tiền
        this.balance += amount;
    }

    public boolean withdraw(double amount) {    //Hành vi rút tiền
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();  //Định danh đối tượng myAccount
        myAccount.openAccount("101202303", "Nguyen Van A");
        myAccount.deposit(500.0);
        myAccount.withdraw(150.0);
    }
}
