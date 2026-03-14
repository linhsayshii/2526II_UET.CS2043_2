import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<IPayable> payablesList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of payables: ");
        int n = Integer.parseInt(sc.nextLine());
        int totalPayment = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter payable " + (i + 1) + ": ");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            
            if (parts[0].equalsIgnoreCase("S")) {
                payablesList.add(new PartTimeStaff(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4])));
            } else if (parts[0].equalsIgnoreCase("I")) {
                payablesList.add(new Invoice(parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
            } else {
                System.out.println("Invalid input format. Skipping this entry.");
            }
            totalPayment += payablesList.get(i).getPaymentAmount();
        }
        System.out.println("----------------------------------------------");
        for (IPayable p : payablesList) {
            System.out.println(p.getType() + " - " + p.getName() + " - Payment: " + p.getPaymentAmount());
        }
        System.out.println("Total payment = " + totalPayment);
    }
}
