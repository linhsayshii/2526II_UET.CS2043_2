public class Worker {
    private volatile boolean running = true;

    // Dùng volatile để đảm bảo rằng khi một thread thay đổi giá trị của biến
    // running,
    // các thread khác sẽ thấy được sự thay đổi đó ngay lập tức
    // Đại loại là mọi dữ liệu đều ghi vào RAM, không ghi vào cache L1 L2 CPU

    public void run() {
        while (running) {
            System.out.println("Worker is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Worker interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
