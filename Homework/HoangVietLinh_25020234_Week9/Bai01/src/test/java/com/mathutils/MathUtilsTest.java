package com.mathutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    void testAdd() {
        assertEquals(5, utils.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, utils.subtract(3, 2));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, utils.divide(5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> utils.divide(5, 0));
    }

    @Test
    void testFactorial() {
        assertEquals(120, utils.factorial(5));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, utils.factorial(0));
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> utils.factorial(-1));
    }
}
