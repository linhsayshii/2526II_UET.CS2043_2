package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingService {

    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            logger.error("Tên không được để trống");
            throw new IllegalArgumentException("Tên không được để trống");
        }
        String result = "Xin chào, " + name + "!";
        logger.info("Tạo lời chào cho: {}", name);
        return result;
    }

    public String formalGreet(String name, String title) {
        if (name == null || title == null) {
            logger.error("Tên và chức danh không được null");
            throw new IllegalArgumentException("Tên và chức danh không được null");
        }
        String result = "Kính chào " + title + " " + name + "!";
        logger.info("Tạo lời chào trang trọng: {} {}", title, name);
        return result;
    }
}
