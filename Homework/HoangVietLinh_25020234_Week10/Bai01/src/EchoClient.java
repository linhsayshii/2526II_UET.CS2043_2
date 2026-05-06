import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * TCP Echo Client - Kết nối đến Server trên port 12345.
 * Gửi tin nhắn và hiển thị phản hồi (echo) từ Server.
 */
public class EchoClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        System.out.println("=== ECHO CLIENT ===");
        System.out.println("Đang kết nối đến " + SERVER_HOST + ":" + SERVER_PORT + "...");

        try (
            // Kết nối đến Server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            // Luồng ghi (gửi tin nhắn đến Server)
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            // Luồng đọc (nhận phản hồi từ Server)
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            // Đọc input từ bàn phím
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Kết nối thành công!");
            System.out.println("Nhập tin nhắn (gõ 'exit' để thoát):\n");

            String message;
            while (true) {
                // Đọc tin nhắn từ người dùng
                System.out.print("Bạn: ");
                message = scanner.nextLine();

                // Gửi tin nhắn lên Server
                output.println(message);

                // Nhận phản hồi từ Server
                String response = input.readLine();
                System.out.println("Server phản hồi: " + response);

                // Thoát nếu gõ "exit"
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("\nĐã ngắt kết nối.");
                    break;
                }
                System.out.println();  // Dòng trống cho dễ đọc
            }

        } catch (ConnectException e) {
            System.err.println("Lỗi: Không thể kết nối đến Server!");
            System.err.println("Hãy chắc chắn Server đã được khởi động trước.");
        } catch (IOException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
