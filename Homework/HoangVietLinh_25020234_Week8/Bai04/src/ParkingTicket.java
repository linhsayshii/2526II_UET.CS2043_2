// === SAU REFACTOR ===
// Áp dụng Move Method + Replace Temp with Query:
// ParkingTicket giờ biết cách tính phí và điểm thưởng của chính nó
// bằng cách ủy quyền (delegate) cho Vehicle
public class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }

    // Replace Temp with Query: thay vì tính thisFee trong receipt(),
    // giờ gọi trực tiếp qua phương thức này
    public double getFee() {
        return vehicle.calculateFee(hours);
    }

    public int getBonusPoints() {
        return vehicle.calculateBonusPoints(hours);
    }
}
