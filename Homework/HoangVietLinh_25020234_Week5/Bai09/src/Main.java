import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String filename = "../students.dat";
        
        System.out.println("Nhập thông tin sinh viên (ID, Name, GPA cách nhau bởi khoảng trắng)");
        System.out.println("Nhập 'END' để kết thúc nhập liệu");

        while (true) {
            System.out.print("Nhập thông tin sinh viên: ");
            String line = sc.nextLine();
            if (line.toUpperCase().equals("END")) {
                break;
            }
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại.");
                continue;
            }
            String id = parts[0];
            String name = parts[1];
            double gpa = Double.parseDouble(parts[2]);
            if (gpa < 0 || gpa > 4) {
                System.out.println("GPA không hợp lệ. Vui lòng nhập lại.");
                continue;
            } else {
                students.add(new Student(id, name, gpa));
            }
        }
        
        // ghi danh sách sinh viên vào file students.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Student s : students) {
                oos.writeObject(s);
            }
            System.out.println("Đã ghi danh sách sinh viên vào file " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // đọc danh sách sinh viên từ file students.dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("Đã đọc danh sách sinh viên từ file " + filename);
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }
        } catch (EOFException e) {
            System.err.println("--Đọc hết file--");
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi IO khi đọc file: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program Finished");
        }
    }
}