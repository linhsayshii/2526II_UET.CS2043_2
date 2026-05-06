# Báo cáo Phân tích - TCP vs UDP (Critical Thinking)

## 1. Ngoại lệ khi chạy 2 CommandServer trên cùng port

### Ngoại lệ: `java.net.BindException: Address already in use`

### Giải thích:
Khi CommandServer-1 gọi `new ServerSocket(5000)`, hệ điều hành **gán quyền sở hữu** port 5000 cho tiến trình (process) này. Port trở thành "đã bận" (occupied).

Khi CommandServer-2 cũng cố `new ServerSocket(5000)`, hệ điều hành kiểm tra thấy port 5000 **đã có chủ** → từ chối → ném `BindException`.

### Nguyên nhân gốc rễ:
Đây là quy tắc của **TCP/IP stack** trong hệ điều hành: mỗi cặp `(IP, Port)` chỉ được **1 socket** bind tại 1 thời điểm. Quy tắc này đảm bảo rằng khi có gói tin đến port 5000, hệ điều hành biết chính xác giao cho chương trình nào.

---

## 2. Tại sao TCP báo lỗi khi không có Server, còn UDP thì không?

### TCP (CommandClient) → `ConnectException`
- TCP là giao thức **hướng kết nối** (connection-oriented)
- Trước khi gửi bất kỳ dữ liệu nào, TCP **bắt buộc** thực hiện **3-way handshake**:
  1. Client gửi `SYN` (xin kết nối)
  2. Server trả `SYN-ACK` (đồng ý)
  3. Client gửi `ACK` (xác nhận)
- Nếu Server **không tồn tại**: bước 2 không có ai trả lời → hệ điều hành Client chờ timeout → báo `ConnectException`
- **Kết luận:** TCP **không cho phép** gửi dữ liệu nếu không có kết nối hợp lệ

### UDP (SensorSender) → Không báo lỗi
- UDP là giao thức **không kết nối** (connectionless)
- UDP hoạt động theo cơ chế **"fire and forget"** (gửi và quên):
  1. Đóng gói dữ liệu vào `DatagramPacket`
  2. Gọi `socket.send(packet)` → gói tin được ném vào mạng
  3. **Không chờ** phản hồi, không kiểm tra ai nhận
- Nếu Receiver **không tồn tại**: gói tin đến đích → hệ điều hành đích nhận gói tin nhưng không có socket nào lắng nghe trên port 6000 → **im lặng hủy bỏ** (ICMP "port unreachable" có thể được gửi nhưng UDP sender không kiểm tra)
- **Kết luận:** UDP **không quan tâm** đích có tồn tại hay không

### So sánh tổng kết

| Tiêu chí | TCP | UDP |
|---|---|---|
| Kết nối | Bắt buộc 3-way handshake | Không cần |
| Gửi khi không có đích | ❌ `ConnectException` | ✅ Gửi bình thường, mất mát im lặng |
| Đảm bảo dữ liệu đến | ✅ Có (ACK cho mỗi segment) | ❌ Không |
| Use case | Lệnh điều khiển, web, email | Streaming, sensor data, DNS |
