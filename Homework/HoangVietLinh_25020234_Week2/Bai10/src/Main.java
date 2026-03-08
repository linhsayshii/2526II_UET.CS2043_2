public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        SmartLight l1 = new SmartLight("L01", "Living Room Light", 80);
        SmartLight l2 = new SmartLight("L002", "Bedroom Light");
        l2.setBrightness("ECO");
        l1.connectToHub(hub);
        l2.connectToHub(hub);
        System.out.println("light1 brightness: " + l1.getBrightness());
        System.out.println("light2 brightness: " + l2.getBrightness());
    }
}