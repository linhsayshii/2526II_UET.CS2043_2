// Loại đơn hàng mới - chỉ cần tạo 1 class, không sửa code cũ!
public class BulkyOrder extends Order {
    public BulkyOrder(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double getDeliveryFee() {
        return weight * 4000 + distance * 600 + 50000;
    }

    @Override
    public String getLabel() {
        return "[HÀNG CỒNG KỀNH]";
    }
}
