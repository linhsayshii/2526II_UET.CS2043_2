import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
    Product[] arr = { new Product("P1", "Macbook", 1000.0),
                    new Product("P2", "iPhone", 1200.0) };
    Inventory kho = new Inventory(arr);
    arr[0].setPrice(5000.0);
    System.out.println(Arrays.toString(kho.getProducts()));
    }
}
    
