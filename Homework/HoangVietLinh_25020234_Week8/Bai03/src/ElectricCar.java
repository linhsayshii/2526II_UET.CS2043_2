public class ElectricCar extends Vehicle {
    private int batteryPercent;

    public ElectricCar(String plate, String brand) {
        super(plate, brand);
        this.batteryPercent = 0;
    }

    @Override
    protected String getTypeName() {
        return "Xe điện";
    }

    public void charge(int percent) {
        batteryPercent += percent;
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }
}
