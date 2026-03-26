import java.util.ArrayList;
import java.util.List;

public class LibrarySection <T extends MediaItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public void displayItems() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}
