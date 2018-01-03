package ru.test.example.allure;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SimpleTest {
    @Test
    public void firstSimpleTest() {
        assertTrue("Result not equals to 4", 2 * 2 == 4);
    }
}
