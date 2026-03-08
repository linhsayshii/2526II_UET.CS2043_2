import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("019878254", 1000.0);
        Transaction transaction1 = new Transaction("T001", 100.0, "2024-06-01 10:00:00");
        Transaction transaction2 = new Transaction("T002", 200.0, "2024-06-01 11:00:00");
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);

        //Act as a hacker try to change transaction history
        System.out.println("Before attacks");
        System.out.println(Arrays.toString(account.getHistory()));
        account.getHistory()[0] = null;
        account.getHistory()[1] = new Transaction("T002", 999999999.0, "2024-06-01 11:00:00");

        //After attacks
        System.out.println("After attacks");
        System.out.println(Arrays.toString(account.getHistory()));
        System.out.println("Account balance: " + account.getBalance());
     }
}
