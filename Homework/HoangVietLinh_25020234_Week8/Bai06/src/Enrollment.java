// Sau refactor - Enrollment liên kết Student với Course và chứa điểm số
public class Enrollment {
    private Student student;
    private Course course;
    private double midtermScore;
    private double finalScore;
    private double assignmentScore;

    public Enrollment(Student student, Course course,
                      double midtermScore, double finalScore, double assignmentScore) {
        this.student = student;
        this.course = course;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.assignmentScore = assignmentScore;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public double getMidtermScore() { return midtermScore; }
    public double getFinalScore() { return finalScore; }
    public double getAssignmentScore() { return assignmentScore; }

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
}
