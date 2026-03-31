package src;
public class SmartFan {
    private String brand = "Xiaomi";
    private boolean isPowerOn = false;
    private int speedLevel = 0; // Mức từ 1 đến 3
    //Trạng thái của quạt (brand, isPowerOn, speedLevel)

    public void turnOn() {  //Hành vi bật quạt
        this.isPowerOn = true;
    }

    public void turnOff() { //Hành vi tắt quạt
        this.isPowerOn = false;
        this.speedLevel = 0;
    }

    public void setSpeed(int newSpeed) {    //Hành vi thay đổi số của quạt
        // Chỉ đổi tốc độ nếu quạt đang bật
        if (this.isPowerOn == true) { 
            this.speedLevel = newSpeed;
        }
    }

    public static void main(String[] args) {
        SmartFan livingRoomFan = new SmartFan();    //Định danh quạt phòng khách
        livingRoomFan.turnOn();
        livingRoomFan.setSpeed(2);

        SmartFan bedroomFan = new SmartFan();   //Định danh quạt phòng ngủ
        bedroomFan.setSpeed(3); 
        bedroomFan.turnOn();
    }
}
