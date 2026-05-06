import java.io.*;
import java.net.*;

/**
 * CommandClient - Kết nối TCP đến CommandServer (port 5000).
 * Gửi tuần tự lệnh "START" và "SHUTDOWN".
 * Bắt ConnectException nếu Server chưa khởi động.
 */
public class CommandClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        System.out.println("=== COMMAND CLIENT (TCP) ===");
        System.out.println("Đang kết nối đến " + SERVER_HOST + ":" + SERVER_PORT + "...\n");

        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            )
        ) {
            System.out.println("Kết nối thành công!\n");

            // Gửi lệnh 1: START
            System.out.println("--- Gửi lệnh: START ---");
            output.println("START");
            String response1 = input.readLine();
            System.out.println("Server phản hồi: " + response1);
            System.out.println();

            // Tạm dừng 1 giây giữa 2 lệnh
            Thread.sleep(1000);

            // Gửi lệnh 2: SHUTDOWN
            System.out.println("--- Gửi lệnh: SHUTDOWN ---");
            output.println("SHUTDOWN");
            String response2 = input.readLine();
            System.out.println("Server phản hồi: " + response2);

            System.out.println("\nĐã hoàn thành gửi lệnh.");

        } catch (ConnectException e) {
            // TCP yêu cầu kết nối TRƯỚC khi gửi dữ liệu
            // Nếu Server chưa chạy → ConnectException
            System.err.println("Error: Remote server is offline!");
            System.err.println("Hãy khởi động CommandServer trước khi chạy Client.");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Bị gián đoạn: " + e.getMessage());
        }
    }
}
