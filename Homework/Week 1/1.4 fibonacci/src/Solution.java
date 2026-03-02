public class Solution {
    public long fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n>92) return -1; //f(93) exceed Long.MAX_VALUE

        long f0=0, f1=1, fn=0;
        for (int i=2; i<=n; i++) {
            fn=f0+f1;
            f0=f1;
            f1=fn;
        }
        return fn;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fibonacci(2));
        System.out.println(sol.fibonacci(10));
        System.out.println(sol.fibonacci(20));
        System.out.println(sol.fibonacci(92));
        System.out.println(sol.fibonacci(93));
    }
}
