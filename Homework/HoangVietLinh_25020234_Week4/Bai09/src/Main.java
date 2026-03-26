import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse<Food> warehouse = new Warehouse<>();
        Warehouse<Electronics> warehouse2 = new Warehouse<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            String value = parts[3];
            switch (type.toLowerCase()) {
                case "f" -> warehouse.addProduct(new Food(id, name, value));
                case "e" -> warehouse2.addProduct(new Electronics(id, name, Integer.parseInt(value)));
                default -> System.err.println("Unknown product type: " + type);
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Kho thực phẩm:");
        warehouse.displayProducts();
        System.out.println();
        System.out.println("Kho điện tử:");
        warehouse2.displayProducts();
    }
}
