import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryHashMap implements ILibrary {
    private final HashMap<String, Book> books = new HashMap<>();
    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    @Override
    public void removeBook(Book book) {
        books.remove(book.getId());
    }
    @Override
    public boolean deleteBookById(String id) {
        return books.remove(id) != null;
    }
    @Override
    public List<Book> searchBooksByTitle(String title) {
        return books.values().stream()
            .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }
    @Override
    public void printAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}