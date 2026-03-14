public class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }
    public void fly() {
        System.out.println("The drone is flying.");
    }
    public void getCoordinates() {
        System.out.println("Getting GPS coordinates.");
    }
    public void turnOn() {
        System.out.println("Turning on the drone.");
    }
    @Override
    public void performMainTask() {
        System.out.println("The DroneRobot is Perfoming ....");
        turnOn();
        fly();
        getCoordinates();
    }
}
