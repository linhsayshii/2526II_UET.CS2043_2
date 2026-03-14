import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        System.out.print("Enter number of products: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double totalPrice = 0;

        for(int i = 0; i < n; i++) {
            System.out.print("Enter product " + (i + 1) + ": ");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            
            if (type.equalsIgnoreCase("E")) {
                double warrantyFee = Double.parseDouble(parts[3]);
                products.add(new Electronics(name, price, warrantyFee));
            } else {
                products.add(new Food(name, price, parts[3]));
            }
            totalPrice += products.get(products.size() - 1).getFinalPrice();
        }
        System.out.println("----------------------------------------------");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getType() + " - " + p.getFinalPrice());
        }
        System.out.println("Total price: " + totalPrice);
    }
}
