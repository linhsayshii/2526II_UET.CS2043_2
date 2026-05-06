package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public int add(int a, int b) {
        int result = a + b;
        logger.info("add({}, {}) = {}", a, b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        logger.info("subtract({}, {}) = {}", a, b, result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        logger.info("multiply({}, {}) = {}", a, b, result);
        return result;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("Phép chia cho 0: a={}", a);
            throw new ArithmeticException("Không thể chia cho 0");
        }
        double result = (double) a / b;
        logger.info("divide({}, {}) = {}", a, b, result);
        return result;
    }
}
