public class SmartLight extends ElectronicDevice implements IAdjustable {
    private int brightness;
    public SmartLight(String id, String name) {
        super(id, name);
        this.brightness = 0; // Default brightness
    }
    public int getBrightness() {
        return brightness;
    }
    protected void setBrightness(int brightness) {
        if (brightness < 0) {
            this.brightness = 0;
        } else if (brightness > 100) {
            this.brightness = 100;
        } else {
            this.brightness = brightness;
        }
    }
    @Override
    public void adjust(int level) {
        this.setBrightness(level);
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
