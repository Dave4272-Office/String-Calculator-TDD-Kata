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

    @Test
    void testMultipleNumberInput() {
        assertEquals(10, App.Add("2,3,4,1"));
        assertEquals(20, App.Add("10,5,5"));
    }

    @Test
    void testInputWithNewLine() {
        assertEquals(6, App.Add("1\n2,3"));
    }
}
