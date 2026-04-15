import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử: ");
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(Math.min(n, 10));
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(executor.submit(new PrimeNumberCounter.PrimeNumberCounterTask(arr)));
        }

        int[] result = new int[n];
        int maxPrime = -1;

        for (int i = 0; i < n; i++) {
            try {
                result[i] = futures.get(i).get();
                System.out.println("Array " + i + ": " + result[i]);
                if (result[i] > maxPrime) {
                    maxPrime = result[i];
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error processing array " + i + ": " + e.getMessage());
                if (e instanceof InterruptedException)
                    Thread.currentThread().interrupt();
            }
        }
        List<Integer> topArrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (result[i] == maxPrime) {
                topArrays.add(i);
            }
        }
        System.out.println("Most primes: ");
        for (int i = 0; i < topArrays.size(); i++) {
            System.out.print("Array " + topArrays.get(i));
            if (i < topArrays.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" with " + maxPrime + " primes.");
        executor.shutdown();
        sc.close();
    }
}
