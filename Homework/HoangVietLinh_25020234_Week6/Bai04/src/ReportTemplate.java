import java.util.ArrayList;
import java.util.List;

public class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate copy = (ReportTemplate) super.clone();
            copy.sections = new ArrayList<>(this.sections);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setTitle(String title) {this.title = title;}
    
    @Override
    public String toString() {
        return "ReportTemplate [title=" + title + ", footer=" + footer + ", sections=" + sections + "]";
    }
}
