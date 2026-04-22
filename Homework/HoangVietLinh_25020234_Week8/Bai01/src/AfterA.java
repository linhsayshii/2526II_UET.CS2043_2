// Đoạn A - SAU refactor
// Áp dụng: Rename Variable / Rename Parameter
// Đổi tên tham số và biến cục bộ cho rõ nghĩa
public class AfterA {
    private static final double MEMBER_DISCOUNT_RATE = 0.9;

    public double calculateFee(String type, int hours, double rate, boolean isMember) {
        double fee = hours * rate;
        if (isMember) {
            fee = fee * MEMBER_DISCOUNT_RATE;
        }
        return fee;
    }
}
