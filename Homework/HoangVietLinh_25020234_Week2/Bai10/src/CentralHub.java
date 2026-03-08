public class CentralHub {
    public CentralHub() {
    }
    public void registerDevice(SmartLight light) {
        System.out.println("[HUB] is connected to " + light.getName());
    }
}