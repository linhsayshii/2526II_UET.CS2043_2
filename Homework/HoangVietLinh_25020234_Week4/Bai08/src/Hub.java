import java.util.ArrayList;
import java.util.List;

public class Hub {
    List <ElectronicDevice> devices = new ArrayList<>();
    public void addDevice(ElectronicDevice device) {
        devices.add(device);
    }
    public void turnOnAll() {
        for (ElectronicDevice device : devices) {
            device.turnOn();
        }
    }
    public void turnOffAll() {
        for (ElectronicDevice device : devices) {
            device.turnOff();
        }
    }
    public void connectAllToWifi(String ssid, String password) {
        for (ElectronicDevice device : devices) {
            if (device instanceof IWifiConnectable) {
                ((IWifiConnectable) device).connectToWifi(ssid, password);
            }
        }
    }
}
