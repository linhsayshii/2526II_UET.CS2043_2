// Đoạn D - SAU refactor
// Áp dụng: Extract Class (tách thông tin tác giả thành class riêng)
public class Author {
    private String email;
    private String name;
    private String phone;
    private String address;

    public Author(String email, String name, String phone, String address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}
