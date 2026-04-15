import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class BookStore {
    private final Map<String, Integer> stock = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void initBook(String title, int quantity) {
        stock.put(title, quantity);
    }

    // --CƠ CHẾ ĐỌC--
    public Integer getStock(String title) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " đang xem số lượng sách: " + title);
            Thread.sleep(500);

            Integer quantity = stock.getOrDefault(title, 0);
            System.out.println(Thread.currentThread().getName() + " -> SÁCH " + title + " HIỆN CÓ: " + quantity);
            return quantity;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            lock.readLock().unlock(); // luôn finally mở khóa
        }
    }

    // --CƠ CHẾ GHI--
    public void addBook(String title, int quantity) {
        lock.writeLock().lock();
        try {
            System.out.println(">>> " + Thread.currentThread().getName() + " ĐANG NHẬP KHO: Thêm " + quantity + " cuốn " + title);
            Thread.sleep(1000);

            stock.put(title, stock.getOrDefault(title, 0) + quantity);
            System.out.println(">>> " + Thread.currentThread().getName() + " ĐÃ NHẬP KHO: " + title + " hiện có: " + stock.get(title));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int quantity) {
        lock.writeLock().lock();
        try {
            System.out.println(">>> " + Thread.currentThread().getName() + " ĐANG MƯỢN SÁCH: " + quantity + " cuốn " + title);
            Thread.sleep(1000);
            
            int currentStock = stock.getOrDefault(title, 0);
            if (currentStock >= quantity) {
                stock.put(title, currentStock - quantity);
                System.out.println(">>> " + Thread.currentThread().getName() + " ĐÃ MƯỢN SÁCH: " + title + " hiện có: " + stock.get(title));
            } else {
                System.out.println(">>> " + Thread.currentThread().getName() + " KHÔNG THỂ MƯỢN: Chỉ còn " + currentStock + " cuốn " + title);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
