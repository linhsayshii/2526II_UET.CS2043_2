public class ActionCharacter {
    public ActionCharacter() {}
    public void fight() {
        System.out.println("Đấm bốc");
    }
}
interface CanFight {
    void fight();
}
interface CanSwim {
    void swim();
}
interface CanFly {
    void fly();
}
