import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * SensorReceiver - Trạm Giám sát (UDP).
 * Lắng nghe trên port 6000, nhận và hiển thị dữ liệu thời tiết.
 */
public class SensorReceiver {
    private static final int PORT = 6000;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        System.out.println("=== SENSOR RECEIVER (UDP - Trạm Giám sát) ===");
        System.out.println("Đang lắng nghe trên port " + PORT + "...\n");

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int packetCount = 0;

            // Vòng lặp liên tục nhận gói tin
            while (true) {
                // Tạo packet trống để nhận dữ liệu
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Chờ nhận gói tin (blocking)
                socket.receive(packet);
                packetCount++;

                // Chuyển dữ liệu byte thành chuỗi
                String data = new String(
                    packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8
                );

                // Hiển thị thông tin
                System.out.println("[Gói #" + packetCount + "] "
                    + "Từ: " + packet.getAddress().getHostAddress()
                    + ":" + packet.getPort()
                    + " → " + data);
            }

        } catch (BindException e) {
            System.err.println("BindException: Port " + PORT + " đã bị sử dụng!");
        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
        }
    }
}
