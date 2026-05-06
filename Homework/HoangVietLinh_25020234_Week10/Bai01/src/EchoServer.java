import java.io.*;
import java.net.*;

/**
 * TCP Echo Server - Lắng nghe trên port 12345.
 * Nhận tin nhắn từ Client và trả về chính xác tin nhắn đó.
 */
public class EchoServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("=== ECHO SERVER ===");
        System.out.println("Đang khởi động server trên port " + PORT + "...");

        // Tạo ServerSocket để lắng nghe kết nối
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server đã sẵn sàng. Đang chờ Client kết nối...\n");

            // Chấp nhận 1 kết nối từ Client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client đã kết nối: " + clientSocket.getInetAddress());

            // Tạo luồng đọc/ghi để giao tiếp với Client
            BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true  // true = auto-flush
            );

            String message;
            // Vòng lặp đọc tin nhắn cho đến khi Client gửi "exit"
            while ((message = input.readLine()) != null) {
                System.out.println("[Nhận từ Client]: " + message);

                // Kiểm tra nếu Client muốn thoát
                if (message.equalsIgnoreCase("exit")) {
                    output.println("Server: Tạm biệt!");
                    System.out.println("Client đã ngắt kết nối.");
                    break;
                }

                // Echo: gửi lại chính xác tin nhắn đó
                output.println(message);
                System.out.println("[Gửi lại Client]: " + message);
            }

            // Đóng kết nối
            clientSocket.close();
            System.out.println("\nServer đã tắt.");

        } catch (IOException e) {
            System.err.println("Lỗi Server: " + e.getMessage());
        }
    }
}
