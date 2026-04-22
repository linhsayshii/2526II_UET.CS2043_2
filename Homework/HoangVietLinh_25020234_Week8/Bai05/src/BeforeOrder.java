// Code gốc - trước refactor
public class BeforeOrder {
    private String type;
    private double weight;
    private double distance;

    public BeforeOrder(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public double getDeliveryFee() {
        if (type.equals("STANDARD")) {
            return weight * 3000 + distance * 500;
        } else if (type.equals("EXPRESS")) {
            return (weight * 3000 + distance * 500) * 1.5;
        } else if (type.equals("FRAGILE")) {
            return weight * 5000 + distance * 700 + 20000;
        }
        throw new IllegalArgumentException("Loại đơn hàng không hợp lệ: " + type);
    }

    public String getLabel() {
        if (type.equals("STANDARD")) return "[THƯỜNG]";
        if (type.equals("EXPRESS"))  return "[HỎA TỐC]";
        if (type.equals("FRAGILE"))  return "[HÀNG DỄ VỠ]";
        return "[KHÔNG XÁC ĐỊNH]";
    }
}
