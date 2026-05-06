import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 * Multi-Thread Server - Hỗ trợ nhiều Client kết nối đồng thời.
 * Mỗi Client được xử lý bởi một luồng (thread) riêng biệt.
 */
public class MultiServer {
    private static final int PORT = 12345;
    private static final Logger logger = Logger.getLogger(MultiServer.class.getName());

    public static void main(String[] args) {
        // Cấu hình logger hiển thị đẹp hơn
        setupLogger();

        logger.info("=== MULTI-THREAD SERVER ===");
        logger.info("Đang khởi động server trên port " + PORT + "...");

        int clientCount = 0;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            logger.info("Server đã sẵn sàng. Đang chờ các Client kết nối...");

            // Vòng lặp vô hạn để chấp nhận nhiều Client
            while (true) {
                // accept() chặn luồng chính cho đến khi có Client mới
                Socket clientSocket = serverSocket.accept();
                clientCount++;

                String clientInfo = "Client-" + clientCount
                    + " [" + clientSocket.getInetAddress().getHostAddress()
                    + ":" + clientSocket.getPort() + "]";

                logger.info("Kết nối mới: " + clientInfo);

                // Tạo luồng riêng để xử lý Client này
                // → Luồng chính KHÔNG bị block, tiếp tục accept() Client khác
                Thread clientThread = new Thread(
                    new ClientHandler(clientSocket, clientInfo, logger)
                );
                clientThread.start();

                logger.info("Tổng số Client đang kết nối: " + clientCount);
            }

        } catch (IOException e) {
            logger.severe("Lỗi Server: " + e.getMessage());
        }
    }

    /**
     * Cấu hình Logger để hiển thị format đẹp hơn trên console.
     */
    private static void setupLogger() {
        // Xóa handler mặc định
        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        // Tạo handler mới với format tùy chỉnh
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("[%1$tF %1$tT] [%2$s] %3$s%n",
                    record.getMillis(), record.getLevel(), record.getMessage());
            }
        });

        Logger appLogger = Logger.getLogger(MultiServer.class.getName());
        appLogger.addHandler(consoleHandler);
        appLogger.setUseParentHandlers(false);
    }
}
