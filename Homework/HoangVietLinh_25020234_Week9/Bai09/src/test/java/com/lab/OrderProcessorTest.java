package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    OrderProcessor processor = new OrderProcessor();

    @Test
    void testProcessOrder_Normal() {
        // 5 * 100000 = 500000 (không giảm giá)
        double result = processor.processOrder("ORD001", "Laptop", 5, 100000);
        assertEquals(500000.0, result);
    }

    @Test
    void testProcessOrder_WithDiscount() {
        // 10 * 200000 = 2000000 > 1000000 → giảm 10% = 1800000
        double result = processor.processOrder("ORD002", "Monitor", 10, 200000);
        assertEquals(1800000.0, result);
    }

    @Test
    void testProcessOrder_InvalidOrderId() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.processOrder("", "Mouse", 1, 50000));
    }

    @Test
    void testProcessOrder_NullOrderId() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.processOrder(null, "Mouse", 1, 50000));
    }

    @Test
    void testProcessOrder_InvalidQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.processOrder("ORD003", "Keyboard", 0, 30000));
    }

    @Test
    void testProcessOrder_NegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.processOrder("ORD004", "Cable", 1, -100));
    }

    @Test
    void testCancelOrder() {
        assertDoesNotThrow(() -> processor.cancelOrder("ORD005"));
    }

    @Test
    void testCancelOrder_Null() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.cancelOrder(null));
    }
}
