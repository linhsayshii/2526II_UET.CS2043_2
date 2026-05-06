import java.io.*;
import java.net.*;

/**
 * CommandServer - Kênh Điều khiển TCP (port 5000).
 * Nhận lệnh "START" / "SHUTDOWN" và phản hồi tương ứng.
 * Tích hợp timeout và xử lý ngoại lệ.
 */
public class CommandServer {
    private static final int PORT = 5000;
    private static final int TIMEOUT_MS = 5000;  // 5 giây timeout

    public static void main(String[] args) {
        System.out.println("=== COMMAND SERVER (TCP - Port " + PORT + ") ===");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Đặt timeout: nếu không có Client kết nối trong 5 giây → bắt exception
            serverSocket.setSoTimeout(TIMEOUT_MS);
            System.out.println("Server đang lắng nghe...");
            System.out.println("Timeout: " + TIMEOUT_MS + "ms\n");

            // Chờ Client kết nối
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client đã kết nối: " + clientSocket.getInetAddress());

            BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true
            );

            String command;
            while ((command = input.readLine()) != null) {
                System.out.println("[Nhận lệnh]: " + command);

                // Xử lý lệnh
                switch (command.toUpperCase()) {
                    case "START":
                        String startResponse = "System initialized...";
                        output.println(startResponse);
                        System.out.println("[Phản hồi]: " + startResponse);
                        break;

                    case "SHUTDOWN":
                        String shutdownResponse = "System shutdown...";
                        output.println(shutdownResponse);
                        System.out.println("[Phản hồi]: " + shutdownResponse);
                        System.out.println("\nServer đang tắt...");
                        clientSocket.close();
                        return;  // Thoát chương trình

                    default:
                        String unknownResponse = "Unknown command: " + command;
                        output.println(unknownResponse);
                        System.out.println("[Phản hồi]: " + unknownResponse);
                }
            }

        } catch (SocketTimeoutException e) {
            // Bắt khi quá thời gian chờ mà không có Client
            System.err.println("SocketTimeoutException: Không có Client kết nối trong "
                + TIMEOUT_MS + "ms.");
            System.err.println("Server tự động tắt do hết thời gian chờ.");

        } catch (BindException e) {
            // Bắt khi port đã bị chiếm bởi chương trình khác
            System.err.println("BindException: Port " + PORT + " đã bị sử dụng!");
            System.err.println("Có thể một CommandServer khác đang chạy trên cùng port.");

        } catch (IOException e) {
            // Bắt các lỗi I/O khác
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
