package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    void caseSensitiveCheck () {
        String result = Task7.main( new String[]{"a", "A"} );
        assertEquals ( result, "[A, a]");

    }

    void lenghtSortCheck() {
        String result = Task7.main( new String[]{"a", "A", "AB", "BA", "AAA", "a"} );
        assertEquals ( result, "[A, a, a, AB, BA, AAA]");
    }

}