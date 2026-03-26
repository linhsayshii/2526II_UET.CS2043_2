import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hub hub = new Hub();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            switch (type.toLowerCase()) {
                case "ac" -> hub.addDevice(new SmartAC(id, name));
                case "l" -> hub.addDevice(new SmartLight(id, name));
                case "c" -> hub.addDevice(new SmartCurtain(id, name));
                case "s" -> hub.addDevice(new SmartSpeaker(id, name));
                default -> System.err.println("Unknown device type: " + type);
            }
        }
        System.out.println("--------------------------------------");
        hub.turnOffAll();
        System.out.println();
        hub.connectAllToWifi("abc", "123");
    }
}
