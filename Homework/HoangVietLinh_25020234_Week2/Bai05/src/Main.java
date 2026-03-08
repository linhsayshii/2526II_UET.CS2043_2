public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 29.99);
        Book book2 = new Book("Java Programming", "John Doe", 29.99);
        System.out.println("Use ==: " + (book1 == book2));
        System.out.println("Use equals(): " + book1.equals(book2));
    }
}