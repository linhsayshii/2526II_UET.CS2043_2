public class NumberWrapper {
    private int n;
    public void setNum(int n) {
        this.n = n;
    }
    public int getNum() {
        return n;
    }
    public static void swap(NumberWrapper a, NumberWrapper b) {
        int temp = a.getNum();
        a.setNum(b.getNum());
        b.setNum(temp);
    }
    public static void main(String[] args) {
        int n1 = 5, n2 = 10;
        NumberWrapper a = new NumberWrapper();
        NumberWrapper b = new NumberWrapper();
        a.setNum(n1);
        b.setNum(n2);
        swap(a, b);
        System.out.println("a = " + a.getNum() + ", b = " + b.getNum());
    }
}