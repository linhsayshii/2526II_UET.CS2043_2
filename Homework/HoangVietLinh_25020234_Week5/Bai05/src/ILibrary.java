import java.util.List;

public interface ILibrary {
    void addBook(Book book);
    void removeBook(Book book);
    boolean deleteBookById(String id);
    List<Book> searchBooksByTitle(String title);
    void printAllBooks();
}