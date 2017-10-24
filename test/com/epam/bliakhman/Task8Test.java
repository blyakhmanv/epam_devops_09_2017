package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @Test
    void intPolindromFinder () {

     assertNull ( Task8.intPolindromFinder(new String[] {"aa", "bbb"}));
     assertEquals ( "2", Task8.intPolindromFinder(new String[] {"aa", "bbb", "123", "121", "qqq", "2"}) );
    }

}