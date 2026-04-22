public class Car extends FuelVehicle {
    public Car(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getTypeName() {
        return "Ô tô";
    }
}
