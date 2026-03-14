public class Food extends Product {
    private String date;
    public Food(String name, double price, String date) {
        super(name, price);
        this.date = date;
    }
    public double getFinalPrice() {
        if (CalDate.isnearlyOutofDate(date)) {
            return super.getFinalPrice()*0.8;
        } else {
            return super.getFinalPrice();
        }
    }
    @Override
    public String getType() {
        return "Food";
    }
}
