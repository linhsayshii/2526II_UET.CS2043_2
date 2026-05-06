package com.mathutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {

    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        int result = a + b;
        logger.info("Phép cộng: {} + {} = {}", a, b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        logger.info("Phép trừ: {} - {} = {}", a, b, result);
        return result;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("Lỗi chia cho 0 với a={}", a);
            throw new ArithmeticException("Không thể chia cho 0");
        }
        double result = (double) a / b;
        logger.info("Phép chia: {} / {} = {}", a, b, result);
        return result;
    }

    public int factorial(int n) {
        if (n < 0) {
            logger.error("Giai thừa của số âm: n={}", n);
            throw new IllegalArgumentException("n phải >= 0");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        logger.info("Giai thừa: {}! = {}", n, result);
        return result;
    }
}
