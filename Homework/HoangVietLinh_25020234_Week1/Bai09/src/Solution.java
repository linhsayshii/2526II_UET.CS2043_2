public class Solution {
    public int sumOfDigits(int n) {
        int sum = 0;
        if (n<0) {
            n=-n;
        }
        while (n>0) {
            int digit=n%10;
            sum+=digit;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfDigits(123));
        System.out.println(sol.sumOfDigits(0));
        System.out.println(sol.sumOfDigits(-456));
    }
}
