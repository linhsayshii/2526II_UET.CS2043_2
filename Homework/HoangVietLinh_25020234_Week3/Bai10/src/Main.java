import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1) + ": ");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts[0].equalsIgnoreCase("E")) {
                employees.add(new Employee(parts[1], Double.parseDouble(parts[2])));
            } else if (parts[0].equalsIgnoreCase("D")) {
                employees.add(new Developer(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            } else if (parts[0].equalsIgnoreCase("T")) {
                employees.add(new Tester(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            } else {
                System.out.println("Invalid input format. Skipping this entry.");
            }
        }
        System.out.println("----------------------------------------------");
        for (Employee e : employees) {
            System.out.println(e.getName() + " - Bonus: " + e.calculateBonus());
            if (e instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (e instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
        }
    }
}