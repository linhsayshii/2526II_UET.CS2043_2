public class Task implements Runnable {
    private final String name;
    private final long durationMs;

    public Task(String name, long durationMs) {
        this.name = name;
        this.durationMs = durationMs;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            Thread.sleep(durationMs);
        } catch (InterruptedException e) {
            System.err.println("Task " + name + " was interrupted.");
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
        System.out.println("End " + name);
    }
}
