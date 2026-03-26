import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String id = parts[0];
            String name = parts[1];
            double gpa = Double.parseDouble(parts[2]);
            students.add(new Student(id, name, gpa));
        }
        System.out.println("----------------------------------------");
        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPS < 5.0:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("After sorting by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();
        // Custom functional interface
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> b!=0 ? a/b : 0.0;

        double sumGpa = 0.0;
        int count = 0;
        for (Student student : students) {
            sumGpa = add.operate(sumGpa, student.getGpa());
            count++;
        }
        double avgGpa = divide.operate(sumGpa, (double) count);
        System.out.printf("Average GPA: %.2f%n", avgGpa);
    }
}

