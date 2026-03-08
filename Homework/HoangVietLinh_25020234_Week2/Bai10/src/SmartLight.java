public class SmartLight {
    private String id;
    private String name;
    private int brightness;
    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }
    public SmartLight(String id, String name) {
        this(id, name, 50);
    }
    public String getName() {
        return name;
    }
    public int getBrightness() {
        return brightness;
    }
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    public void setBrightness(String preset) {
        switch (preset.toLowerCase()) {
            case "max":
                this.setBrightness(100);
                break;
            case "min":
                this.setBrightness(0);
                break;
            case "eco":
                this.setBrightness(30);
                break;
            default:
                System.out.println("Invalid preset");
        }
    }
    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }
}