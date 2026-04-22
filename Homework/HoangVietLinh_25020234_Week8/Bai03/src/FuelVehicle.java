// Lớp trung gian cho xe chạy xăng - chứa fuelLevel
public abstract class FuelVehicle extends Vehicle {
    protected double fuelLevel;

    public FuelVehicle(String plate, String brand) {
        super(plate, brand);
        this.fuelLevel = 0;
    }

    public void refuel(double liters) {
        fuelLevel += liters;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
}
