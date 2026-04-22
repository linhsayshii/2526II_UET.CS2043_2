import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== TRƯỚC REFACTOR ==========");
        printBeforeRefactor();

        System.out.println();

        System.out.println("========== SAU REFACTOR ==========");
        printAfterRefactor();
    }

    private static void printBeforeRefactor() {
        // Dùng class gốc (Before)
        BeforeVehicle car = new BeforeVehicle("30A-12345", BeforeVehicle.CAR);
        BeforeVehicle bike = new BeforeVehicle("29B-67890", BeforeVehicle.BIKE);
        BeforeVehicle truck = new BeforeVehicle("51C-11111", BeforeVehicle.TRUCK);

        BeforeParkingTicket t1 = new BeforeParkingTicket(car, 5);
        BeforeParkingTicket t2 = new BeforeParkingTicket(bike, 2);
        BeforeParkingTicket t3 = new BeforeParkingTicket(truck, 6);

        BeforeParkingCustomer customer = new BeforeParkingCustomer("Nguyen Van A");
        customer.addTicket(t1);
        customer.addTicket(t2);
        customer.addTicket(t3);

        System.out.println(customer.receipt());
    }

    private static void printAfterRefactor() {
        // Dùng class đã refactor (dùng đa hình)
        Vehicle car = new Car("30A-12345");
        Vehicle bike = new Bike("29B-67890");
        Vehicle truck = new Truck("51C-11111");

        ParkingTicket t1 = new ParkingTicket(car, 5);
        ParkingTicket t2 = new ParkingTicket(bike, 2);
        ParkingTicket t3 = new ParkingTicket(truck, 6);

        ParkingCustomer customer = new ParkingCustomer("Nguyen Van A");
        customer.addTicket(t1);
        customer.addTicket(t2);
        customer.addTicket(t3);

        System.out.println(customer.receipt());
    }
}
