package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest {

    GreetingService service = new GreetingService();

    @Test
    void testGreet() {
        assertEquals("Xin chào, Linh!", service.greet("Linh"));
    }

    @Test
    void testGreetEmpty() {
        assertThrows(IllegalArgumentException.class, () -> service.greet(""));
    }

    @Test
    void testGreetNull() {
        assertThrows(IllegalArgumentException.class, () -> service.greet(null));
    }

    @Test
    void testFormalGreet() {
        assertEquals("Kính chào TS Nguyễn!", service.formalGreet("Nguyễn", "TS"));
    }

    @Test
    void testFormalGreetNull() {
        assertThrows(IllegalArgumentException.class,
            () -> service.formalGreet(null, "TS"));
    }
}
