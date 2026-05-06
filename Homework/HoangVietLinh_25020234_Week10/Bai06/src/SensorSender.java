import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * SensorSender - Trạm Thời tiết (UDP).
 * Gửi dữ liệu cảm biến đến SensorReceiver qua UDP port 6000.
 * UDP không cần kết nối → gửi mà không cần Receiver sẵn sàng.
 */
public class SensorSender {
    private static final String RECEIVER_HOST = "localhost";
    private static final int RECEIVER_PORT = 6000;

    public static void main(String[] args) {
        System.out.println("=== SENSOR SENDER (UDP - Trạm Thời tiết) ===");
        System.out.println("Đang gửi dữ liệu đến port " + RECEIVER_PORT + "...\n");

        // Dữ liệu mẫu để gửi
        String[] sensorData = {
            "Temp: 28°C, Humidity: 65%",
            "Temp: 29°C, Humidity: 63%",
            "Temp: 27°C, Humidity: 70%",
            "Temp: 30°C, Humidity: 58%",
            "Temp: 26°C, Humidity: 72%"
        };

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(RECEIVER_HOST);

            for (int i = 0; i < sensorData.length; i++) {
                String data = sensorData[i];
                byte[] buffer = data.getBytes(StandardCharsets.UTF_8);

                // Tạo gói tin UDP
                DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length, address, RECEIVER_PORT
                );

                // Gửi gói tin (KHÔNG cần kết nối, KHÔNG báo lỗi nếu không có Receiver)
                socket.send(packet);
                System.out.println("[Gửi #" + (i + 1) + "]: " + data);

                // Đợi 1 giây giữa mỗi lần gửi (mô phỏng real-time)
                Thread.sleep(1000);
            }

            System.out.println("\nĐã gửi xong " + sensorData.length + " gói dữ liệu.");

        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Bị gián đoạn: " + e.getMessage());
        }
    }
}
