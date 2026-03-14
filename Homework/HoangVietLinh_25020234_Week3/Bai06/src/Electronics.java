public class Electronics extends Product {
    private double WarrantyFee;
    public Electronics(String name, double price, double WarrantyFee) {
        super(name, price);
        this.WarrantyFee = WarrantyFee;
    }
    public double getFinalPrice() {
        return super.getFinalPrice()*1.1 + WarrantyFee;
    }
    @Override
    public String getType() {
        return "Electronics";
    }
    
}
