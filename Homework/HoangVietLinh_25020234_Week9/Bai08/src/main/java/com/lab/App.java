package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("=== Ứng dụng Greeting khởi động ===");

        GreetingService service = new GreetingService();

        String greeting = service.greet("Sinh viên UET");
        logger.info("Kết quả: {}", greeting);

        String formal = service.formalGreet("Giảng viên", "Tiến sĩ");
        logger.info("Kết quả: {}", formal);

        logger.info("=== Ứng dụng kết thúc ===");
    }
}
