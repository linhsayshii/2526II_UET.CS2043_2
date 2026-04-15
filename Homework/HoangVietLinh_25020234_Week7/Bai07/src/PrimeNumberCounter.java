import java.util.concurrent.*;

public class PrimeNumberCounter {
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static class PrimeNumberCounterTask implements Callable<Integer> {
        private final int[] arr;

        public PrimeNumberCounterTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        public Integer call() {
            int count = 0;
            for (int num : arr) {
                if (isPrime(num))
                    count++;
            }
            return count;
        }
    }
}
