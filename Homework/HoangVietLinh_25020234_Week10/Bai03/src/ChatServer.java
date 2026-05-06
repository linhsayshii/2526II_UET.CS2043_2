import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * REST API Chat Server - Hệ thống chat theo phòng.
 * Sử dụng HttpServer có sẵn trong JDK (không cần thư viện ngoài).
 * 
 * Endpoints:
 *   POST /join     → Tham gia phòng, nhận Client ID
 *   POST /send     → Gửi tin nhắn (query param: clientId)
 *   GET  /messages → Lấy toàn bộ tin nhắn trong phòng
 */
public class ChatServer {
    private static final int PORT = 8080;

    // ID tự tăng cho mỗi Client mới tham gia
    private static AtomicInteger nextClientId = new AtomicInteger(1);

    // Danh sách Client đã tham gia (lưu ID và tên)
    private static Map<Integer, String> clients = new HashMap<>();

    // Danh sách tin nhắn trong phòng
    private static List<String> messages = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Đăng ký các endpoint
        server.createContext("/join", new JoinHandler());
        server.createContext("/send", new SendHandler());
        server.createContext("/messages", new MessagesHandler());

        server.start();
        System.out.println("=== REST API CHAT SERVER ===");
        System.out.println("Server đang chạy tại http://localhost:" + PORT);
        System.out.println("Endpoints:");
        System.out.println("  POST /join              → Tham gia phòng");
        System.out.println("  POST /send?clientId=X   → Gửi tin nhắn");
        System.out.println("  GET  /messages          → Xem tin nhắn");
    }

    /**
     * POST /join - Client tham gia phòng và nhận ID duy nhất.
     */
    static class JoinHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equals(exchange.getRequestMethod())) {
                sendResponse(exchange, 405, "Method Not Allowed. Dùng POST.");
                return;
            }

            // Đọc tên từ body (nếu có)
            String body = new String(
                exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8
            ).trim();
            String name = body.isEmpty() ? "Anonymous" : body;

            // Tạo ID mới
            int clientId = nextClientId.getAndIncrement();
            clients.put(clientId, name);

            // Thông báo vào phòng
            String joinMsg = "[Hệ thống] " + name + " (ID: " + clientId + ") đã tham gia phòng.";
            messages.add(joinMsg);

            String response = "Chào mừng " + name + "! Client ID của bạn là: " + clientId;
            System.out.println("[JOIN] " + name + " → ID: " + clientId);
            sendResponse(exchange, 200, response);
        }
    }

    /**
     * POST /send?clientId=X - Client gửi tin nhắn vào phòng.
     */
    static class SendHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equals(exchange.getRequestMethod())) {
                sendResponse(exchange, 405, "Method Not Allowed. Dùng POST.");
                return;
            }

            // Lấy clientId từ query parameter
            String query = exchange.getRequestURI().getQuery();
            if (query == null || !query.contains("clientId=")) {
                sendResponse(exchange, 400, "Thiếu tham số clientId. VD: /send?clientId=1");
                return;
            }

            int clientId;
            try {
                clientId = Integer.parseInt(query.split("clientId=")[1].split("&")[0]);
            } catch (NumberFormatException e) {
                sendResponse(exchange, 400, "clientId phải là số nguyên.");
                return;
            }

            // Kiểm tra Client đã tham gia chưa
            if (!clients.containsKey(clientId)) {
                sendResponse(exchange, 403, "Bạn chưa tham gia phòng! Gọi POST /join trước.");
                return;
            }

            // Đọc nội dung tin nhắn từ body
            String content = new String(
                exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8
            ).trim();

            if (content.isEmpty()) {
                sendResponse(exchange, 400, "Tin nhắn không được để trống.");
                return;
            }

            // Thêm tin nhắn vào danh sách chung (broadcast)
            String name = clients.get(clientId);
            String fullMessage = name + " (ID:" + clientId + "): " + content;
            messages.add(fullMessage);

            System.out.println("[MSG] " + fullMessage);
            sendResponse(exchange, 200, "Tin nhắn đã gửi thành công.");
        }
    }

    /**
     * GET /messages - Liệt kê toàn bộ tin nhắn trong phòng.
     */
    static class MessagesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"GET".equals(exchange.getRequestMethod())) {
                sendResponse(exchange, 405, "Method Not Allowed. Dùng GET.");
                return;
            }

            // Ghép tất cả tin nhắn thành chuỗi
            StringBuilder sb = new StringBuilder();
            sb.append("=== TIN NHẮN TRONG PHÒNG ===\n");
            if (messages.isEmpty()) {
                sb.append("(Chưa có tin nhắn nào)\n");
            } else {
                for (int i = 0; i < messages.size(); i++) {
                    sb.append((i + 1) + ". " + messages.get(i) + "\n");
                }
            }
            sb.append("Tổng: " + messages.size() + " tin nhắn");

            sendResponse(exchange, 200, sb.toString());
        }
    }

    /**
     * Gửi HTTP response cho Client.
     */
    private static void sendResponse(HttpExchange exchange, int code, String body)
            throws IOException {
        byte[] responseBytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(code, responseBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }
}
