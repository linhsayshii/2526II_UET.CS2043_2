public class Book {
    private String title;
    private String author;
    private double price;
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Book otherBook = (Book) obj;
        return Double.compare(this.price, otherBook.price) == 0 && 
            this.title.equals(otherBook.title) &&
            this.author.equals(otherBook.author);
    }
}