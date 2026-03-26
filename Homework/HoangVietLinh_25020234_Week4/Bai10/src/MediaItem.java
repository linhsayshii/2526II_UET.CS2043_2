public abstract class MediaItem {
    private String id;
    private String name;
    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getDetails();
}
