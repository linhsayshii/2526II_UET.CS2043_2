import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotificationApp app;

        System.out.println("Chọn kênh gửi (1: Email, 2: SMS): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            app = new EmailApp();
        } else {
            app = new SmsApp();
        }

        app.notifyUser("Chào mừng bạn đến với hệ thống!");
    }
}