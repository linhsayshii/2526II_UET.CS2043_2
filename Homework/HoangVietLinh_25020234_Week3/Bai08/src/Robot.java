public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;
    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }
    public void changeBattery (int n) {
        batteryLevel = 100;
    }
    public final void showIndentity() {
        System.out.println("ID: " + id);
        System.out.println("Model Name: " + modelName);
    }
    public abstract void performMainTask();
}
interface Flyable {
    void fly();
}
interface Swimmable {       
    void swim();
}
interface GPS {
    void getCoordinates();
}
interface ElectronicDevice {
    void turnOn();
}