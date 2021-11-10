package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testEmptyStringInput() {
        assertEquals(0, App.Add(""));
    }

    @Test
    void testSingleNumberInput() {
        assertEquals(1, App.Add("1"));
    }

    @Test
    void testTwoNumberInput() {
        assertEquals(5, App.Add("2,3"));
    }
}
