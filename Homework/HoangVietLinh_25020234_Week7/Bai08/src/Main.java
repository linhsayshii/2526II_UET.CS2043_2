import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();

        ExecutorService pool1 = Executors.newFixedThreadPool(Math.min(n, 3));
        ExecutorService pool2 = Executors.newFixedThreadPool(Math.min(n, 3));
        List<CompletableFuture<Long>> pipelines = new ArrayList<>();

        int[][] arrs = new int[n][];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            arrs[i] = new int[m];
            for (int j = 0; j < m; j++) {
                arrs[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            final int arrayIndex = i;
            final int[] arr = arrs[i];
            CompletableFuture<Long> pipeline = CompletableFuture
                    .supplyAsync(() -> {
                        List<Integer> primes = new ArrayList<>();
                        for (int num : arr) {
                            if (Processor.isPrime(num)) {
                                primes.add(num);
                            }
                        }
                        System.out.println("Stage 1 - Array " + arrayIndex + ": " + primes.size() + " primes");
                        return new Processor.stage1Result(arrayIndex, primes);
                    }, pool1)

                    .thenApplyAsync(result -> {
                        long sum = 0;
                        int count = result.primes.size();
                        if (count % 2 == 0) {
                            for (int p : result.primes) {
                                sum += (long) p * p;
                            }
                            System.out.println("Stage 2 - Array " + result.index + ": sum of squares = " + sum);
                        } else {
                            for (int p : result.primes) {
                                sum += (long) p * p * p;
                            }
                            System.out.println("Stage 2 - Array " + result.index + ": sum of cubes = " + sum);
                        }
                        return sum;
                    }, pool2);
            pipelines.add(pipeline);
        }
        long totalSum = 0;
        for (CompletableFuture<Long> pipeline : pipelines) {
            try {
                totalSum += pipeline.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error processing array: " + e.getMessage());
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Total = " + totalSum);
        pool1.shutdown();
        pool2.shutdown();
        sc.close();
    }
}
