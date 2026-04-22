// === CODE GỐC (trước refactor) ===
public class BeforeParkingTicket {
    private final BeforeVehicle vehicle;
    private final int hours;

    public BeforeParkingTicket(BeforeVehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }
    public BeforeVehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }
}
