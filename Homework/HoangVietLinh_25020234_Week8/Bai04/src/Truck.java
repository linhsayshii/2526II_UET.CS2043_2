public class Truck extends Vehicle {
    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double calculateFee(int hours) {
        return 15 + hours * 4;
    }

    @Override
    public int calculateBonusPoints(int hours) {
        // Truck gửi > 5 tiếng được thêm 1 điểm
        return (hours > 5) ? 2 : 1;
    }
}
