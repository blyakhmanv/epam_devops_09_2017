package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static com.epam.bliakhman.Task15.sortMatrixByValuesInColumn;
import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    @Test
    void sortMatrixByValuesInColumnTest () {

        int[][] testarray = new int[][]{{1,2,3},{-1,2,5},{1,-2,7}};
        assertEquals ( -1, sortMatrixByValuesInColumn(testarray,0)[0][0] );
        assertEquals ( 2, sortMatrixByValuesInColumn(testarray,1)[2][1] );
    }

}