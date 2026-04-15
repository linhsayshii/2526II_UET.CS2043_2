import java.util.concurrent.Callable;

public class SecondLargestSum {
    static class SecondLargestSumTask implements Callable<Integer> {
        private final int[] arr;

        public SecondLargestSumTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        public Integer call() {
            if (arr == null || arr.length < 2) {
                return null; // Không đủ phần tử để tính
            }
            Integer max1 = null, max2 = null;
            for (int num : arr) {
                if (max1 == null || num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num < max1 && (max2 == null || num > max2)) {
                    max2 = num;
                }
            }
            return max2;
        }
    }
}
