package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testSupportDelimiterChange() {
        assertEquals(3, App.Add("//;\n1;2"));
    }

    @Test
    void testExceptionAtNegativeInput() {
        Exception gotException = assertThrows(Exception.class, () -> {
            App.Add("-1");
        });

        assertEquals("negatives not allowed -1", gotException.getMessage());

        gotException = assertThrows(Exception.class, () -> {
            App.Add("-1,4,5");
        });

        assertEquals("negatives not allowed -1", gotException.getMessage());
    }

    @Test
    void testExceptionForMultipleNegativeInput() {
        Exception gotException = assertThrows(Exception.class, () -> {
            App.Add("1,-1,4,5,-6,8");
        });

        assertEquals("negatives not allowed -1 -6", gotException.getMessage());
    }
}
