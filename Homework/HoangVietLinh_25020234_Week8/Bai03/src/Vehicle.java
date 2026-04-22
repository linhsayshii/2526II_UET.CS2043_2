public abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    protected abstract String getTypeName();

    public String getInfo() {
        return getTypeName() + " [" + plate + "] - " + brand;
    }
}
