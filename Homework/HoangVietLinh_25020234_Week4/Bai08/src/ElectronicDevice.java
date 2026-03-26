public class ElectronicDevice {
    private String id;
    private String name;
    private boolean isOn;

    public ElectronicDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public boolean isOn() {
        return isOn;
    }
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }
}
