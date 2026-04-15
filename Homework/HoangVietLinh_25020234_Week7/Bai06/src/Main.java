import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Future<Integer>> future = new ArrayList<>();

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int threadCount = Math.min(n, 4); // Giới hạn số thread tối đa là 4
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }

            Callable<Integer> task = new SecondLargestSum.SecondLargestSumTask(arr);
            future.add(executor.submit(task));
        }

        int totalSum = 0;
        for (int i = 0; i<n; i++) {
            try {
                Integer secondLargest = future.get(i).get();
                if (secondLargest == null) {
                    System.out.println("Array " + i + ": Not found");
                } else {
                    System.out.println("Array " + i + ": Second largest = " + secondLargest);
                    totalSum += secondLargest;
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Array " + i + ": Not found");
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Total sum of second largest elements: " + totalSum);
        executor.shutdown();
        sc.close();
    }
}
