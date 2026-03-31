import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- TESTING LIBRARY ARRAYLIST ---");
        testLibrary(new LibraryArrayList());

        System.out.println("\n--- TESTING LIBRARY HASHMAP ---");
        testLibrary(new LibraryHashMap());

        System.out.println("\n--- TESTING LIBRARY TREEMAP ---");
        testLibrary(new LibraryTreeMap());
    }

    private static void testLibrary(ILibrary library) {
        // 1. Thêm ít nhất 5 cuốn sách
        library.addBook(new Book("B01", "Java Programming", "John Smith", 2020));
        library.addBook(new Book("B02", "Data Structures", "Alice Cooper", 2019));
        library.addBook(new Book("B03", "Algorithms", "Bob Martin", 2021));
        library.addBook(new Book("B04", "Database Systems", "Eve Online", 2018));
        library.addBook(new Book("B05", "Machine Learning", "Charlie Brown", 2022));

        System.out.println("All books after adding:");
        library.printAllBooks();

        // 2. Thực hiện tìm kiếm
        String searchTitle = "Java";
        System.out.println("\nSearching for books with title containing: " + searchTitle);
        List<Book> searchResults = library.searchBooksByTitle(searchTitle);
        
        // 4. In danh sách kết quả (từ tìm kiếm)
        System.out.println("Search results:");
        for (Book book : searchResults) {
            System.out.println(book);
        }

        // 3. Thực hiện xóa
        String idToDelete = "B02";
        System.out.println("\nDeleting book with ID: " + idToDelete);
        boolean deleted = library.deleteBookById(idToDelete);
        System.out.println("Deleted successfully: " + deleted);

        System.out.println("\nFinal book list after deletion:");
        library.printAllBooks();
    }
}

