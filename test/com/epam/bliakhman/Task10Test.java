package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    @Test
    void isPowerOfTwoTrue () {
        assertTrue ( Task10.isPowerOfTwo ( 1L));
        assertTrue ( Task10.isPowerOfTwo ( 2L));
        assertTrue ( Task10.isPowerOfTwo ( 2048L));
    }
    @Test
    void isPowerOfTwoFalse () {
        assertFalse ( Task10.isPowerOfTwo ( 3L));
        assertFalse ( Task10.isPowerOfTwo ( 7L));
        assertFalse ( Task10.isPowerOfTwo ( 2000L));
    }
}