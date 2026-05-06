package com.lab;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class FilePathUtilsTest {

    FilePathUtils utils = new FilePathUtils();

    // ============================================================
    // BÀI TEST SAI (HARDCODED) - Chỉ chạy được trên 1 OS
    // Uncomment để thấy lỗi trên OS không tương thích
    // ============================================================

    // @Test
    // void testBroken_HardcodedWindowsPath() {
    //     // Dùng dấu \ cứng → CHỈ chạy được trên Windows
    //     String path = "data\\output\\result.txt";
    //     assertTrue(path.contains("\\"));  // Fail trên Linux/Mac
    // }

    // @Test
    // void testBroken_HardcodedLinuxPath() {
    //     // Dùng dấu / cứng → FAIL trên Windows khi so sánh path
    //     String expected = "data/output/result.txt";
    //     String actual = utils.buildPath("data", "output", "result.txt");
    //     assertEquals(expected, actual);  // Fail trên Windows (vì separator là \)
    // }

    // ============================================================
    // BÀI TEST ĐÚNG - Chạy được trên mọi OS
    // ============================================================

    @Test
    void testBuildPath_CrossPlatform() {
        // Dùng Path.of() để tạo expected path → đúng trên mọi OS
        String expected = Path.of("data", "output", "result.txt").toString();
        String actual = utils.buildPath("data", "output", "result.txt");
        assertEquals(expected, actual);
    }

    @Test
    void testBuildPath_UsingFileSeparator() {
        // Dùng File.separator để kiểm tra → đúng trên mọi OS
        String result = utils.buildPath("home", "user", "file.txt");
        assertTrue(result.contains("home"));
        assertTrue(result.contains("user"));
        assertTrue(result.contains("file.txt"));
        // Kiểm tra separator đúng cho OS hiện tại
        assertTrue(result.contains(File.separator));
    }

    @Test
    void testGetFileName() {
        String path = Path.of("data", "output", "result.txt").toString();
        assertEquals("result.txt", utils.getFileName(path));
    }

    @Test
    void testBuildPath_SingleElement() {
        String result = utils.buildPath("file.txt");
        assertEquals("file.txt", result);
    }

    @Test
    void testBuildPath_Empty() {
        assertThrows(IllegalArgumentException.class, () -> utils.buildPath());
    }
}
