
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Nhập đường dẫn tệp đích: ");
        String destinationPath = scanner.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            try {
                reader = new BufferedReader(new FileReader(sourcePath));
            } catch (FileNotFoundException e) {
                System.err.println("Source file not found.");
                return;
            }
            try {
                writer = new PrintWriter(new FileWriter(destinationPath));
            } catch (FileNotFoundException e) {
                System.err.println("Cannot create destination file.");
                return;
            } catch (IOException e) {
                System.err.println("I/O error.");
                e.printStackTrace();
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }
            System.out.println("Sao chép thành công. Số dòng đã sao chép: " + lineCount);

        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("I/O error khi đóng tệp.");
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}