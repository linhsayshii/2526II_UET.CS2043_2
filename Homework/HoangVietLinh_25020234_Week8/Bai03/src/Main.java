public class Main {
    public static void main(String[] args) {
        MotorBike motorBike = new MotorBike("59A-12345", "Honda");
        motorBike.refuel(5.0);

        Car car = new Car("30H-67890", "Toyota");
        car.refuel(40.0);

        ElectricCar electricCar = new ElectricCar("30E-11111", "VinFast");
        electricCar.charge(80);

        // Gọi getInfo() cho tất cả
        Vehicle[] vehicles = { motorBike, car, electricCar };
        System.out.println("=== Thông tin các phương tiện ===");
        for (Vehicle v : vehicles) {
            System.out.println(v.getInfo());
        }

        System.out.println("\n=== Chi tiết năng lượng ===");
        System.out.println(motorBike.getInfo() + " | Xăng: " + motorBike.getFuelLevel() + "L");
        System.out.println(car.getInfo() + " | Xăng: " + car.getFuelLevel() + "L");
        System.out.println(electricCar.getInfo() + " | Pin: " + electricCar.getBatteryPercent() + "%");
    }
}
