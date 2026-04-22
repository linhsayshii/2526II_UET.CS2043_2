// Code gốc chưa sửa - dùng để chạy test phát hiện bug
public class BuggyGradeClassifier {

    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        }
        if (gpa <= 5.0) return "Yếu";      // BUG: <= thay vì <
        if (gpa <= 6.5) return "Trung bình";
        if (gpa < 8.0)  return "Khá";
        return "Giỏi";
    }
}
