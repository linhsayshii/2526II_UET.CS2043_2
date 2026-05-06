import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Chat Client - Kết nối đến Multi-Thread Server.
 * Gửi tin nhắn và hiển thị phản hồi.
 */
public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        System.out.println("=== CHAT CLIENT ===");
        System.out.println("Đang kết nối đến " + SERVER_HOST + ":" + SERVER_PORT + "...");

        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            Scanner scanner = new Scanner(System.in)
        ) {
            // Nhận lời chào từ Server
            String welcome = input.readLine();
            System.out.println(welcome);
            System.out.println("Nhập tin nhắn (gõ 'exit' để thoát):\n");

            String message;
            while (true) {
                System.out.print("Bạn: ");
                message = scanner.nextLine();

                // Gửi tin nhắn
                output.println(message);

                // Nhận phản hồi
                String response = input.readLine();
                if (response != null) {
                    System.out.println("Server: " + response);
                }

                // Thoát
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("\nĐã ngắt kết nối.");
                    break;
                }
                System.out.println();
            }

        } catch (ConnectException e) {
            System.err.println("Lỗi: Không thể kết nối! Server chưa khởi động.");
        } catch (IOException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
