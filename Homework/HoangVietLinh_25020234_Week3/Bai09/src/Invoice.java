public class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;
    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
    @Override
    public String getName() {
        return this.itemName;
    }
    @Override
    public String getType() {
        return "Invoice";
    }
}
