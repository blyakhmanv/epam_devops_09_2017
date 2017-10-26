package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task11Test {
    @Test
    void getSumDigits () {
        assertEquals ( 0, Task11.getSumDigits (0L) );
        assertEquals ( 5, Task11.getSumDigits (-5L) );
        assertEquals ( 6, Task11.getSumDigits (15L) );
        assertEquals ( 24, Task11.getSumDigits (-789L) );
    }

}