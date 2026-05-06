import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * REST API Chat Client - Giao tiếp với ChatServer qua HTTP.
 * Sử dụng HttpURLConnection có sẵn trong JDK.
 */
public class ChatClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static int myClientId = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== REST API CHAT CLIENT ===\n");

        // Bước 1: Tham gia phòng
        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Anonymous";

        String joinResponse = sendPost(BASE_URL + "/join", name);
        if (joinResponse == null) {
            System.err.println("Không thể kết nối đến Server! Hãy khởi động Server trước.");
            return;
        }
        System.out.println("Server: " + joinResponse);

        // Trích xuất clientId từ phản hồi
        try {
            String idPart = joinResponse.split("là: ")[1];
            myClientId = Integer.parseInt(idPart.trim());
        } catch (Exception e) {
            System.err.println("Không thể lấy Client ID.");
            return;
        }

        System.out.println("\nBạn đã tham gia phòng với ID: " + myClientId);
        System.out.println("Các lệnh:");
        System.out.println("  - Nhập tin nhắn → gửi vào phòng");
        System.out.println("  - /list         → xem tất cả tin nhắn");
        System.out.println("  - /exit         → thoát\n");

        // Bước 2: Vòng lặp chat
        while (true) {
            System.out.print("Bạn: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("/exit")) {
                System.out.println("Tạm biệt!");
                break;
            }

            if (input.equalsIgnoreCase("/list")) {
                // Lấy danh sách tin nhắn
                String messages = sendGet(BASE_URL + "/messages");
                System.out.println("\n" + messages + "\n");
                continue;
            }

            if (input.isEmpty()) {
                continue;
            }

            // Gửi tin nhắn
            String sendResponse = sendPost(
                BASE_URL + "/send?clientId=" + myClientId, input
            );
            System.out.println("Server: " + sendResponse);
        }

        scanner.close();
    }

    /**
     * Gửi HTTP POST request.
     */
    private static String sendPost(String urlString, String body) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");

            // Ghi body
            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes(StandardCharsets.UTF_8));
            os.close();

            // Đọc phản hồi
            return readResponse(conn);
        } catch (ConnectException e) {
            return null;
        } catch (IOException e) {
            return "Lỗi: " + e.getMessage();
        }
    }

    /**
     * Gửi HTTP GET request.
     */
    private static String sendGet(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            return readResponse(conn);
        } catch (IOException e) {
            return "Lỗi: " + e.getMessage();
        }
    }

    /**
     * Đọc nội dung phản hồi từ HTTP connection.
     */
    private static String readResponse(HttpURLConnection conn) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
        );
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString().trim();
    }
}
