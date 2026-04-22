public class DiscountCalculator {
    public double calculateDiscount(double price, String memberType) {
        if (price < 0) {
            throw new IllegalArgumentException("Giá không hợp lệ: " + price);
        }
        if (memberType == null) {
            throw new IllegalArgumentException("Loại thành viên không hợp lệ: null");
        }

        switch (memberType) {
            case "GUEST":
                return 0;
            case "MEMBER":
                if (price < 100) return price * 0.05;
                else return price * 0.10;
            case "VIP":
                if (price < 100) return price * 0.15;
                else return price * 0.20;
            default:
                throw new IllegalArgumentException("Loại thành viên không hợp lệ: " + memberType);
        }
    }
}
