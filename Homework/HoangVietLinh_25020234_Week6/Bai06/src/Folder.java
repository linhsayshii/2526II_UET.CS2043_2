import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem{
    private List<FileSystemItem> children = new ArrayList<>();
    public Folder(String name) {
        super(name);
    }
    public void add(FileSystemItem item) {children.add(item); }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "  ");
        }
    }
}
