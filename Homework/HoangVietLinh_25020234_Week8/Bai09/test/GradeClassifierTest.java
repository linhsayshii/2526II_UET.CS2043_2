import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    // ========== EP: Các lớp tương đương ==========

    // Lớp: Ngoài phạm vi (gpa < 0)
    @Test
    void testGradeNegative() {
        assertThrows(IllegalArgumentException.class,
            () -> GradeClassifier.classifyGrade(-1.0));
    }

    // Lớp: Ngoài phạm vi (gpa > 10)
    @Test
    void testGradeAboveTen() {
        assertThrows(IllegalArgumentException.class,
            () -> GradeClassifier.classifyGrade(11.0));
    }

    // Lớp: [0.0, 5.0) → "Yếu"
    @Test
    void testGradeYeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
    }

    // Lớp: [5.0, 6.5) → "Trung bình"
    @Test
    void testGradeTrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.5));
    }

    // Lớp: [6.5, 8.0) → "Khá"
    @Test
    void testGradeKha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    // Lớp: [8.0, 10.0] → "Giỏi"
    @Test
    void testGradeGioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    // ========== BVA: Giá trị biên ==========

    // Biên dưới: gpa = 0.0 → "Yếu"
    @Test
    void testBoundary_0() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
    }

    // Biên: gpa = 4.9 → "Yếu"
    @Test
    void testBoundary_4_9() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
    }

    // Biên: gpa = 5.0 → "Trung bình" (đây là test phát hiện bug!)
    @Test
    void testBoundary_5_0() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
    }

    // Biên: gpa = 5.1 → "Trung bình"
    @Test
    void testBoundary_5_1() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.1));
    }

    // Biên: gpa = 6.4 → "Trung bình"
    @Test
    void testBoundary_6_4() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
    }

    // Biên: gpa = 6.5 → "Khá"
    @Test
    void testBoundary_6_5() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
    }

    // Biên: gpa = 6.6 → "Khá"
    @Test
    void testBoundary_6_6() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.6));
    }

    // Biên: gpa = 7.9 → "Khá"
    @Test
    void testBoundary_7_9() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
    }

    // Biên: gpa = 8.0 → "Giỏi"
    @Test
    void testBoundary_8_0() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
    }

    // Biên: gpa = 8.1 → "Giỏi"
    @Test
    void testBoundary_8_1() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.1));
    }

    // Biên: gpa = 10.0 → "Giỏi"
    @Test
    void testBoundary_10_0() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    // ========== Test ngoại lệ với thông báo ==========

    @Test
    void testException_negative_0_1() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> GradeClassifier.classifyGrade(-0.1)
        );
        assertTrue(ex.getMessage().contains("GPA không hợp lệ"));
    }

    @Test
    void testException_10_1() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> GradeClassifier.classifyGrade(10.1)
        );
        assertTrue(ex.getMessage().contains("GPA không hợp lệ"));
    }
}
