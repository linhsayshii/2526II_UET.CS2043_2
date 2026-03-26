public abstract class Product {
    private String id;
    private String name;
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getDetails();
}