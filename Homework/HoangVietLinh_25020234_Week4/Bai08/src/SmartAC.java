public class SmartAC extends ElectronicDevice implements IWifiConnectable {
    private String ssid;
    private String password;

    public SmartAC(String id, String name) {
        super(id, name);
    }
    @Override
    public void connectToWifi(String ssid, String password) {
        System.out.println(getName() + " connected to WiFi");
    }
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(getName() + " turned on");
    }
    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(getName() + " turned off");
    }
}