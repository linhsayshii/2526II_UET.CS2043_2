// Đoạn D - SAU refactor
// Report chỉ giữ thông tin thuộc về báo cáo, thông tin tác giả nằm trong Author
public class Report {
    private String title;
    private String content;
    private Author author;

    public Report(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Author getAuthor() { return author; }
}
