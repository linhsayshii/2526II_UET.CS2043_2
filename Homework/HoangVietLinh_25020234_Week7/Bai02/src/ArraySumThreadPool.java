import java.util.concurrent.Callable;

public class ArraySumThreadPool {
    static class SumTask implements Callable<Integer> {
        private final int[] array;
        private final int startIndex;
        private final int endIndex;

        public SumTask(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
            return sum;
        }
    }
}
