public class Main {
    public static void main(String[] args) {
        System.out.println("========== TRƯỚC REFACTOR ==========");
        BeforeOrder[] beforeOrders = {
            new BeforeOrder("STANDARD", 2.0, 10.0),
            new BeforeOrder("EXPRESS",  3.0, 15.0),
            new BeforeOrder("FRAGILE",  1.5, 8.0),
            new BeforeOrder("STANDARD", 5.0, 20.0)
        };
        for (BeforeOrder o : beforeOrders) {
            System.out.println(o.getLabel() + " | Phí: " + o.getDeliveryFee());
        }

        System.out.println("\n========== SAU REFACTOR ==========");
        Order[] afterOrders = {
            new StandardOrder(2.0, 10.0),
            new ExpressOrder(3.0, 15.0),
            new FragileOrder(1.5, 8.0),
            new StandardOrder(5.0, 20.0)
        };
        for (Order o : afterOrders) {
            System.out.println(o.getLabel() + " | Phí: " + o.getDeliveryFee());
        }

        System.out.println("\n========== THÊM LOẠI BULKY ==========");
        Order bulky = new BulkyOrder(10.0, 25.0);
        System.out.println(bulky.getLabel() + " | Phí: " + bulky.getDeliveryFee());
    }
}
