package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.epam.bliakhman.Task16.horizontalCyclicShift;
import static com.epam.bliakhman.Task16.verticalCyclicShift;
import static org.junit.jupiter.api.Assertions.*;

class Task16Test {
    @Test
    void verticalCyclicShifttest () {
        int[][] array = new int[][]{{0,5},{1,5},{2,5},{3,5}};
        assertTrue ( Arrays.equals ( array, verticalCyclicShift ( array, 0 ) ) );
        assertTrue ( Arrays.deepEquals ( new int[][]{{2,5},{3,5},{0,5},{1,5}}, verticalCyclicShift ( array, 2 ) ) );
        array = new int[][]{{0,5},{1,5},{2,5},{3,5}};
        assertTrue ( Arrays.deepEquals ( new int[][]{{1,5},{2,5},{3,5},{0,5}}, verticalCyclicShift ( array, -9 ) ) );
    }

    @Test
    void horizontalCyclicShiftTest () {
        int[][] array = new int[][]{{0,5},{1,5},{2,5},{3,5}};
        assertTrue ( Arrays.equals ( array, horizontalCyclicShift ( array, 0 ) ) );
        assertTrue ( Arrays.deepEquals ( new int[][]{{0,5},{1,5},{2,5},{3,5}}, horizontalCyclicShift ( array, 2 ) ) );
        array = new int[][]{{0,5},{1,5},{2,5},{3,5}};
        assertTrue ( Arrays.deepEquals ( new int[][]{{5,0},{5,1},{5,1},{5,3}}, horizontalCyclicShift ( array, -9 ) ) );
    }

}