public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static int totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
    public static void updateTaxRate(double newTaxRate) {
        taxRate = newTaxRate;
    }
    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }
    public double calculateFinalPrice() {
        return price * (1 - discount) * (1 + taxRate);
    }
    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            totalRevenue += calculateFinalPrice() * amount;
            System.out.println("Sold " + amount + " products.");
        } else {
            System.err.println("Out of stock for " + amount + "products.");
        }
    }
    public static int totalRevenue() {
        return totalRevenue;
    }
}
