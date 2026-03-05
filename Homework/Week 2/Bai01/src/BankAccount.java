public class BankAccount {
    private final String accountNumber;
    private double balance = 0.0;
    private final String ownerName;

    BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.ownerName = ownerName;
    }
    BankAccount(String accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        if (balance < 0) {
            System.out.println("Lowest balance is 0. Default balance is 0 now.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        this.ownerName = ownerName;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public double getBalance() {
        return this.balance;
    }
    //Hàm main thử nghiệm
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO TÀI KHOẢN ---");
        BankAccount acc = new BankAccount("123456789", 500.0, "Nguyen Van A");
        
        System.out.println("\n--- KỊCH BẢN 1: Nạp tiền âm ---");
        boolean w0 = acc.deposit(-100.0);
        System.out.println("Trạng thái nạp -100: " + (w0 ? "Thành công" : "Thất bại"));
        
        System.out.println("\n--- KỊCH BẢN 2: Rút quá số dư ---");
        boolean w1 = acc.withdraw(1000.0); 
        System.out.println("Trạng thái rút 1000: " + (w1 ? "Thành công" : "Thất bại"));
        
        System.out.println("\n--- KỊCH BẢN 3: Rút tiền hợp lệ ---");
        boolean w2 = acc.withdraw(200.0);
        System.out.println("Trạng thái rút 200: " + (w2 ? "Thành công" : "Thất bại"));
        
        System.out.println("\nSố dư cuối cùng: " + acc.getBalance());
    }
}
