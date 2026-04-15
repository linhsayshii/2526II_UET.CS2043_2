public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100000.0);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100.0);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(100.0);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Lỗi khi chờ các luồng kết thúc: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("Số dư cuối cùng của tài khoản: " + account.getBalance());
    }
}