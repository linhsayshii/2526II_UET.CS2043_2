public class Electronics extends Product {
    private int warrantyMonths;
    public Electronics(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }
    @Override
    public String getDetails() {
        return super.getName() + " - " + warrantyMonths + " tháng bảo hành";
    }
}