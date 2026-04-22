// Sau refactor - Extract Class: tách thông tin sinh viên
// Có thể dùng lại cho TeachingAssistant (trợ giảng cũng có id, name)
public class Student {
    private String studentId;
    private String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
}
