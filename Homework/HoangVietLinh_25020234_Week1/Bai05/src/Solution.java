public class Solution {
    public int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b==0) return a;
        return gcd(b, a%b);
    }
    public static void main(String [] args) {
        Solution sol = new Solution();
        System.out.println(sol.gcd(48,24));
        System.out.println(sol.gcd(36,18));
        System.out.println(sol.gcd(0,5));
        System.out.println(sol.gcd(3,4));
    }
}
