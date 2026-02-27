public class Solution {
    public int reverse(int n) {
        if (n > Integer.MAX_VALUE) return 0;
        int reversed=0;
        while (n!=0) {
            int digit=n%10;
            reversed=reversed*10+digit;
            n/=10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(12345));
        System.out.println(sol.reverse(-123));
        System.out.println(sol.reverse(100));
        System.out.println(sol.reverse(0));
    }

}
