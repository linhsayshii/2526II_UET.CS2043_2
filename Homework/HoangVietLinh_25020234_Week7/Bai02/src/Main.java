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

        System.out.print("Nhập số lượng phần tử n: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Số lượng phần tử phải lớn hơn 0.");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập " + n + " phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = 4;
        k = Math.min(k, n);
        int chunkSize = (int) Math.ceil((double) n / k);

        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int startIndex = i * chunkSize;
            int endIndex = Math.min(startIndex + chunkSize, n);
            if (startIndex < n) {
                Callable<Integer> task = new ArraySumThreadPool.SumTask(arr, startIndex, endIndex);
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
        }

        int totalSum = 0;
        try {
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            } 
            System.out.println("Tổng của mảng bằng " + k + " luồng là: " + totalSum);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Lỗi khi tính toán đa luồng: " + e.getMessage());
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        } finally {
            executor.shutdown();
            sc.close();
        }
    }
}
