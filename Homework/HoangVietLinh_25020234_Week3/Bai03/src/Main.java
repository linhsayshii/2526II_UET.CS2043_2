public class Main {
    public static void main(String[] args) {
        MathUtils m = new AdvancedMath(); //change MathUtils to AdvanedMath then can compile (B)
        System.out.println(m.sum(5, 5)); // (A)
        //System.out.println(m.sum(5.5, 5.5)); // (B)
    }
}