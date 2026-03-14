import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee " + (i + 1) + ": ");
            String line = sc.nextLine().trim();

            // 1. Tìm vị trí các dấu ngoặc kép
            int firstQuote = line.indexOf("\"");
            int lastQuote = line.lastIndexOf("\"");

            // 2. Cắt lấy Loại nhân viên (F hoặc P)
            String type = line.substring(0, firstQuote).trim();

            // 3. Cắt lấy Tên (bỏ qua dấu ngoặc kép)
            String name = line.substring(firstQuote + 1, lastQuote);

            // 4. Cắt lấy phần số còn lại sau dấu ngoặc kép cuối
            String numPart = line.substring(lastQuote + 1).trim();
            String[] numbers = numPart.split("\\s+"); // Tách các số theo khoảng trắng

            if (type.equalsIgnoreCase("F")) {
                double base = Double.parseDouble(numbers[0]);
                double bonus = Double.parseDouble(numbers[1]);
                double penalty = Double.parseDouble(numbers[2]);
                employees.add(new FullTimeEmployee(name, base, bonus, penalty));
            } else {
                int hours = Integer.parseInt(numbers[0]);
                double rate = Double.parseDouble(numbers[1]);
                employees.add(new PartTimeEmployee(name, hours, rate));
            }
        }
        
        for (Employee e : employees) {
            System.out.println(e.getName() + " - " + e.getType() + " - " + e.getSalary());
        }
    }
}