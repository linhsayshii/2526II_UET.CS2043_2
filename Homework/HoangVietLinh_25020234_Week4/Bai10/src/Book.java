public class Book extends MediaItem {
    private String author;
    private int pages;
    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }
    @Override
    public String getDetails() {
        return super.getName() + " - " + author + " - " + pages;
    }
}
