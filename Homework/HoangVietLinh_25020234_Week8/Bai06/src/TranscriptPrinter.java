// Sau refactor - tách trách nhiệm in ấn ra class riêng
public class TranscriptPrinter {
    public static void printTranscript(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        Course course = enrollment.getCourse();

        System.out.println("Sinh viên: " + student.getName() + " (" + student.getStudentId() + ")");
        System.out.println("Môn học: " + course.getCourseName() + " (" + course.getCourseId()
                         + ") - " + course.getCredits() + " tín chỉ");
        System.out.println("Điểm GK: " + enrollment.getMidtermScore()
                         + " | Điểm CK: " + enrollment.getFinalScore()
                         + " | Điểm BT: " + enrollment.getAssignmentScore());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                          enrollment.calculateFinalGrade(), enrollment.getAcademicStatus());
    }
}
