// Đề xuất cho TeachingAssistant: tạo lớp cha chung Person
// Person chứa id và name (thuộc tính chung)
// Student kế thừa Person, thêm gpa
// TeachingAssistant kế thừa Person, không cần gpa
public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
