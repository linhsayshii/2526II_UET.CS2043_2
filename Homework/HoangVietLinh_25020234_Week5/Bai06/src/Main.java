import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a / b);
        } catch (ArithmeticException f) {
            System.out.println("Error: " + f.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Vui lòng nhập số nguyên hợp lệ."); 
        } finally {
            sc.close();
            System.out.println("Program Finished");
        }
    }
}