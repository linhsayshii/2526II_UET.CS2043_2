public class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    public Hero() {}
    @Override
    public void fly() {
        System.out.println("Anh hùng đang bay");
    }
    @Override
    public void swim() {
        System.out.println("Anh hùng đang bơi");
    }
    /*@Override
    public void fight() {
        System.out.println("Anh hùng đang đấm bốc");
    }
    */
}
