// === CODE GỐC (trước refactor) ===
public class BeforeVehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;

    private final String plate;
    private final int type;

    public BeforeVehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }
    public String getPlate() { return plate; }
    public int getType() { return type; }
}
