public class SmartCurtain extends ElectronicDevice {
    private int position; //from 0 to 100
    public SmartCurtain(String id, String name) {
        super(id, name);
        this.position = 0; // Initially closed
    }
    public int getPosition() {

        return position;
    }
    @Override
    public void turnOn() {
        super.turnOn();
        position = 100;
        System.out.println(getName() + " turned on");
    }
    @Override
    public void turnOff() {
        super.turnOff();
        position = 0;
        System.out.println(getName() + " turned off");
    }
}
