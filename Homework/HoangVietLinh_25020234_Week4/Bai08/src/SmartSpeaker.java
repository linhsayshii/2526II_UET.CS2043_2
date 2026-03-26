public class SmartSpeaker extends ElectronicDevice implements IWifiConnectable, IAdjustable {
    private String ssid;
    private String password;
    private int volume;
    public SmartSpeaker(String id, String name) {
        super(id, name);
        this.volume = 0;
    }
    public int getVolume() {
        return volume;
    }
    protected void setVolume(int volume) {

        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = volume;
        }
    }
    @Override
    public void connectToWifi(String ssid, String password) {
        this.ssid = ssid;
        this.password = password;
        System.out.println(getName() + " connected to WiFi");
    }
    @Override
    public void adjust(int level) {
        this.setVolume(level);
        System.out.println(getName() + " volume adjusted to: " + level);
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
