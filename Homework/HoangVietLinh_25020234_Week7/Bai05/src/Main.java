import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng đơn hàng: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i=0; i<n; i++) {
            System.out.print("Nhập ID đơn hàng: ");
            String id = sc.nextLine();
            System.out.print("Nhập thời gian xử lý (ms): ");
            long processMs = sc.nextLong();

            OrderProcessingSystem.OrderTask task = new OrderProcessingSystem.OrderTask(id, processMs, logs, successCount);
            futures.add(executor.submit(task));
        }

        System.out.println("\n-- HỆ THỐNG ĐANG XỬ LÝ ---");
        for (Future<Boolean> future : futures) {
            try {
                future.get(); // chờ tất cả task hoàn thành
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Lỗi khi xử lý đơn hàng: " + e.getMessage());
            }
        }
        System.out.print("\n--- KẾT QUẢ XỬ LÝ ---\n");
        System.out.println("Success = " + successCount.get());
        System.out.println("Logs:");
        logs.forEach(System.out::println);

        executor.shutdown();
        sc.close();
    }
}
