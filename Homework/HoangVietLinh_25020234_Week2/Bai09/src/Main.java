import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    static Product readProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter product quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product discount: ");
        double discount = sc.nextDouble();
        sc.nextLine();
        return new Product(name, price, qty, discount);
    }

    static int readNumber() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
    public static void main(String[] args) {
       Product p1 = readProduct();
       Product p2 = readProduct();
       System.out.print("Enter sell quantity for product 1: ");
       p1.sell(readNumber());
       System.out.print("Enter sell quantity for product 2: ");
       p2.sell(readNumber());

       //I. Final Price before change tax rate
        System.out.println("I. Final Price before change tax rate");
        System.out.println("Final price of product 1: " + p1.calculateFinalPrice());
        System.out.println("Final price of product 2: " + p2.calculateFinalPrice());

       //II. Change tax rate and final price after change tax rate
        System.out.println();
        System.out.println("II. Change tax rate and final price after change tax rate");
        Product.updateTaxRate(0.08);
        System.out.println("Final price of product 1 after change tax rate: " + p1.calculateFinalPrice());
        System.out.println("Final price of product 2 after change tax rate: " + p2.calculateFinalPrice());

        //III. Change discount and final price after change discount
        System.out.println();
        System.out.println("III. Change discount and final price after change discount");
        p1.updateDiscount(10.0);
        System.out.println("Final price of product 1 after change discount: " + p1.calculateFinalPrice());
        System.out.println("Final price of product 2 after change discount: " + p2.calculateFinalPrice());

        //IV. Total revenue        
        System.out.println();
        System.out.println("IV. Total revenue: " + Product.totalRevenue());
    }
}
