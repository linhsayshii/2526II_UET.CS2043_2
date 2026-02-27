public class SmartFan {
    private String brand = "Xiaomi";
    private boolean isPowerOn = false;
    private int speedLevel = 0; // Mức từ 1 đến 3

    public void turnOn() {
        this.isPowerOn = true;
    }

    public void turnOff() {
        this.isPowerOn = false;
        this.speedLevel = 0;
    }

    public void setSpeed(int newSpeed) {
        // Chỉ đổi tốc độ nếu quạt đang bật
        if (this.isPowerOn == true) { 
            this.speedLevel = newSpeed;
        }
    }

    public static void main(String[] args) {
        SmartFan livingRoomFan = new SmartFan();
        livingRoomFan.turnOn();
        livingRoomFan.setSpeed(2);

        SmartFan bedroomFan = new SmartFan();
        bedroomFan.setSpeed(3); 
        bedroomFan.turnOn();
    }
}
