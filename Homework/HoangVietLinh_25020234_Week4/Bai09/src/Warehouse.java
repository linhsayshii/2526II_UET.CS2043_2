import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends Product> {
    private List<T> products = new ArrayList<>();
    public void addProduct(T product) {
        products.add(product);
    }
    public void exportProducts(T product) {
        if (products.contains(product)) {
            products.remove(product);
        } else {
            System.err.println("Sản phẩm không tồn tại trong kho.");
        }
    }
    public void displayProducts() {
        for (T product : products) {
            System.out.println(product.getDetails());
        }
    }
}
