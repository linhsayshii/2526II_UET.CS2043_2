// Code gốc - God Class: làm quá nhiều việc trong 1 lớp
public class BeforeStudentManager {
    private String studentId;
    private String name;
    private double gpa;

    private String courseId;
    private String courseName;
    private int credits;

    private double midtermScore;
    private double finalScore;
    private double assignmentScore;

    public double calculateFinalGrade() {
        return assignmentScore * 0.2 + midtermScore * 0.3 + finalScore * 0.5;
    }

    public String getAcademicStatus() {
        double grade = calculateFinalGrade();
        if (grade >= 8.5) return "Giỏi";
        if (grade >= 7.0) return "Khá";
        if (grade >= 5.5) return "Trung bình";
        return "Yếu";
    }

    public void printTranscript() {
        System.out.println("Sinh viên: " + name + " (" + studentId + ")");
        System.out.println("Môn học: " + courseName + " (" + courseId + ") - " + credits + " tín chỉ");
        System.out.println("Điểm GK: " + midtermScore + " | Điểm CK: " + finalScore
                         + " | Điểm BT: " + assignmentScore);
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                          calculateFinalGrade(), getAcademicStatus());
    }

    // Setter methods
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setMidtermScore(double midtermScore) { this.midtermScore = midtermScore; }
    public void setFinalScore(double finalScore) { this.finalScore = finalScore; }
    public void setAssignmentScore(double assignmentScore) { this.assignmentScore = assignmentScore; }
}
