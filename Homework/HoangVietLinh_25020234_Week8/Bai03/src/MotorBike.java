public class MotorBike extends FuelVehicle {
    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    protected String getTypeName() {
        return "Xe máy";
    }
}
