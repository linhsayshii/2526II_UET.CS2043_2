package com.lab;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilePathUtils {

    private static final Logger logger = LoggerFactory.getLogger(FilePathUtils.class);

    /**
     * Tạo đường dẫn file đa nền tảng (cross-platform).
     * Sử dụng java.nio.file.Path để tự động chọn separator đúng cho OS.
     */
    public String buildPath(String... parts) {
        if (parts == null || parts.length == 0) {
            logger.error("Không có phần tử nào để tạo đường dẫn");
            throw new IllegalArgumentException("Cần ít nhất 1 phần tử");
        }
        Path path = Path.of(parts[0], java.util.Arrays.copyOfRange(parts, 1, parts.length));
        String result = path.toString();
        logger.info("Tạo đường dẫn: {}", result);
        return result;
    }

    /**
     * Lấy tên file từ đường dẫn.
     */
    public String getFileName(String fullPath) {
        Path path = Path.of(fullPath);
        String fileName = path.getFileName().toString();
        logger.info("Tên file từ '{}' là '{}'", fullPath, fileName);
        return fileName;
    }
}
