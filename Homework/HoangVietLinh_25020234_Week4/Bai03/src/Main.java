import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        System.out.print("Nhập số lượng nhân viên: ");
        int n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập thông tin nhân viên thứ " + (i + 1) + ": ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine().trim();
            String[] parts = str.split("\\s+");
            String emptype = parts[0];
            if (emptype.equalsIgnoreCase("O")) {
                OfficeWorker worker = new OfficeWorker(parts[1], parts[2], Double.parseDouble(parts[3]));
                employees.add(worker);
            } else if (emptype.equalsIgnoreCase("T")) {
                Technician technician = new Technician(parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
                employees.add(technician);
            } else {
                System.out.println("Invalid employee type");
            }
        }
        System.out.println("------------------------------");
        int TotalPay = 0;
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - Pay: " + employee.calculatePay());
            employee.work();
            System.out.println("------------------------------");
            TotalPay += employee.calculatePay();
        }
        System.out.println("Total Pay = " + TotalPay);
    }
}
