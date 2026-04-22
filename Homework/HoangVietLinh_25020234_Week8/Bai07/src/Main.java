public class Main {
    public static void main(String[] args) {
        DiscountCalculator calc = new DiscountCalculator();

        System.out.println("=== Kiểm tra DiscountCalculator ===");
        System.out.println("GUEST, price=50:   " + calc.calculateDiscount(50, "GUEST"));
        System.out.println("MEMBER, price=50:  " + calc.calculateDiscount(50, "MEMBER"));
        System.out.println("MEMBER, price=100: " + calc.calculateDiscount(100, "MEMBER"));
        System.out.println("VIP, price=50:     " + calc.calculateDiscount(50, "VIP"));
        System.out.println("VIP, price=200:    " + calc.calculateDiscount(200, "VIP"));

        // Test exception
        try {
            calc.calculateDiscount(-1, "GUEST");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception (price<0): " + e.getMessage());
        }
        try {
            calc.calculateDiscount(50, "UNKNOWN");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception (unknown type): " + e.getMessage());
        }
    }
}
