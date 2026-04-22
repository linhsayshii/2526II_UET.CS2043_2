// TeachingAssistant kế thừa Person - có id, name nhưng không có gpa
public class TeachingAssistant extends Person {
    private String department;

    public TeachingAssistant(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() { return department; }
}
