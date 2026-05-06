import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 * ClientHandler - Xử lý giao tiếp với một Client cụ thể trên luồng riêng.
 * Implements Runnable để có thể chạy trên Thread riêng biệt.
 */
public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private String clientInfo;
    private Logger logger;

    public ClientHandler(Socket clientSocket, String clientInfo, Logger logger) {
        this.clientSocket = clientSocket;
        this.clientInfo = clientInfo;
        this.logger = logger;
    }

    @Override
    public void run() {
        try (
            // Tạo luồng đọc/ghi cho Client này
            BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true
            )
        ) {
            // Gửi lời chào khi Client vừa kết nối
            output.println("Chào mừng " + clientInfo + "! Gõ 'exit' để thoát.");
            logger.info(clientInfo + " đã sẵn sàng giao tiếp.");

            String message;
            // Đọc tin nhắn liên tục từ Client
            while ((message = input.readLine()) != null) {
                logger.info(clientInfo + " gửi: \"" + message + "\"");

                // Kiểm tra lệnh thoát
                if (message.equalsIgnoreCase("exit")) {
                    output.println("Server: Tạm biệt " + clientInfo + "!");
                    logger.info(clientInfo + " đã ngắt kết nối.");
                    break;
                }

                // Echo: gửi lại tin nhắn kèm thông tin Client
                String response = "[Echo từ Server] " + message;
                output.println(response);
                logger.info(clientInfo + " nhận phản hồi: \"" + response + "\"");
            }

        } catch (IOException e) {
            logger.warning(clientInfo + " - Lỗi kết nối: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                logger.info(clientInfo + " - Kết nối đã đóng.");
            } catch (IOException e) {
                logger.severe(clientInfo + " - Lỗi khi đóng socket: " + e.getMessage());
            }
        }
    }
}
