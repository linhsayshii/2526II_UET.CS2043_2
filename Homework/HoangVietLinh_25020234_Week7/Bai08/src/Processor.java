import java.util.List;

public class Processor {
    static class stage1Result {
        int index;
        List<Integer> primes;

        public stage1Result(int index, List<Integer> primes) {
            this.index = index;
            this.primes = primes;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
