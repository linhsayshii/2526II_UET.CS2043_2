import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @BeforeAll
    static void beforeAll() {
        // @BeforeAll bắt buộc phải là static vì nó chạy TRƯỚC KHI bất kỳ instance nào
        // của test class được tạo ra. JUnit tạo instance mới cho mỗi test method,
        // nên không có instance nào để gọi phương thức non-static tại thời điểm này.
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=== Kết thúc ===");
    }

    // ========== TEST max(a, b) ==========

    // EP: a > b → trả về a
    @Test
    void testMax_aGreaterThanB() {
        assertEquals(5, MathUtils.max(5, 3));
    }

    // EP: a < b → trả về b
    @Test
    void testMax_aLessThanB() {
        assertEquals(7, MathUtils.max(4, 7));
    }

    // EP: a == b → trả về a (hoặc b, vì bằng nhau)
    @Test
    void testMax_aEqualsB() {
        assertEquals(5, MathUtils.max(5, 5));
    }

    // BVA: a = Integer.MAX_VALUE
    @Test
    void testMax_aIsMaxValue() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    }

    // BVA: b = Integer.MAX_VALUE
    @Test
    void testMax_bIsMaxValue() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
    }

    // BVA: a = Integer.MIN_VALUE
    @Test
    void testMax_aIsMinValue() {
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
    }

    // BVA: b = Integer.MIN_VALUE
    @Test
    void testMax_bIsMinValue() {
        assertEquals(0, MathUtils.max(0, Integer.MIN_VALUE));
    }

    // BVA: cả hai đều là MIN_VALUE
    @Test
    void testMax_bothMinValue() {
        assertEquals(Integer.MIN_VALUE, MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    // BVA: cả hai đều là MAX_VALUE
    @Test
    void testMax_bothMaxValue() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    // ========== TEST divide(a, b) ==========

    // EP: b > 0 → chia bình thường
    @Test
    void testDivide_positiveB() {
        assertEquals(3, MathUtils.divide(10, 3));
    }

    // EP: b < 0 → chia bình thường (kết quả âm)
    @Test
    void testDivide_negativeB() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    // EP: b == 0 → ném ngoại lệ
    @Test
    void testDivide_byZero() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> MathUtils.divide(10, 0)
        );
        assertEquals("Divider must not be zero", ex.getMessage());
    }

    // Trường hợp a = 0
    @Test
    void testDivide_aIsZero() {
        assertEquals(0, MathUtils.divide(0, 5));
    }

    // Trường hợp cả hai âm
    @Test
    void testDivide_bothNegative() {
        assertEquals(2, MathUtils.divide(-10, -5));
    }
}
