package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @Test
    void intPolindromFinder () {

     assertNull ( Task8.intPolindromFinder(new String[] {"aa", "bbb"}));
     assertEquals ( "1", Task8.intPolindromFinder(new String[] {"1"}));
     assertEquals ( "111", Task8.intPolindromFinder(new String[] {"111", "123a"}));
     assertEquals ( "111", Task8.intPolindromFinder(new String[] {"111", "123"}));
     assertEquals ( "2", Task8.intPolindromFinder(new String[] {"aa", "bbb", "123", "121", "qqq", "2"}) );
     }

}