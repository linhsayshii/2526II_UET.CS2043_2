// Đoạn A - TRƯỚC refactor
// Code smell: Mysterious Name (tên biến/tham số quá ngắn, không rõ nghĩa)
public class BeforeA {
    public double calculateFee(String t, int h, double r, boolean m) {
        double f = h * r;
        if (m) f = f * 0.9;
        return f;
    }
}
