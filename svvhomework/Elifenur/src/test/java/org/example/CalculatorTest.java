/************
 T.C. Sakarya University
 SWE202 Software Verification and Validation Homework 1
 Elife Nur KARŞIN
 B211202058
 https://github.com/Elifenur/SVV-HOMEWORK.git
 */

package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("divisionTestData")
    void testDivision(float dividend, float divisor, float expected) {
        assertEquals(expected, Calculator.divide(dividend, divisor));
    }

    private static Object[][] divisionTestData() {
        return new Object[][] {
                {10, 2, 5},
                {10, 4, 2.5f},
                {12.5f, 2.5f, 5},
                {10, 2.5f, 4},
                {12.5f, 5, 2.5f}
        };
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

    }
}