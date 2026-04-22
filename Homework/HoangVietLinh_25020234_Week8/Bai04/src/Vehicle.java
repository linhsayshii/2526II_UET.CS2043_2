// === SAU REFACTOR ===
// Áp dụng Replace Conditional with Polymorphism:
// Vehicle là lớp trừu tượng, mỗi loại xe tự định nghĩa logic tính phí và điểm thưởng
public abstract class Vehicle {
    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() { return plate; }

    // Mỗi lớp con tự tính phí gửi xe (Move Method từ ParkingCustomer)
    public abstract double calculateFee(int hours);

    // Mỗi lớp con tự tính điểm thưởng
    public abstract int calculateBonusPoints(int hours);
}
