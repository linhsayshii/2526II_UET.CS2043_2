public class Inventory {
    private Product[] items;
    public Inventory(Product[] items) {
        this.items = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = new Product(items[i]);
        }
    }
    public Product[] getProducts() {
        return items;
    }
    
}
