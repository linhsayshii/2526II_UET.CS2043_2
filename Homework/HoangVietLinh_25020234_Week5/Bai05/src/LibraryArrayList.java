import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryArrayList implements ILibrary {
    private final ArrayList<Book> books = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
    @Override
    public boolean deleteBookById(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
    @Override
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }
    @Override
    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}