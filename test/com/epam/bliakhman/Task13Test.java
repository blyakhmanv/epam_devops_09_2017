package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static com.epam.bliakhman.Task13.getMonthByNumber;
import static org.junit.jupiter.api.Assertions.*;

class Task13Test {
    @Test
    void getMonthByNumberTest () {
        assertEquals ( "March", getMonthByNumber ( 3 ) );
        assertNotEquals ( "June", getMonthByNumber ( 5 ) );
        assertEquals ( "", getMonthByNumber ( -1 ) );
    }

}