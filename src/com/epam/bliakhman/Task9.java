package com.epam.bliakhman;

public class Task9 {

    public static void main (String[] args) {

        System.out.println(createIncreasingSequenceFromZeroTo(12) );
        System.out.println (createMonotoneSequence(10, 15) );
        System.out.println (createMonotoneSequence(15, 10) );
    }

    private static String createIncreasingSequenceFromZeroTo(int value) {
        if (value == 0) {
            return "0";
        }
        else {
            return createIncreasingSequenceFromZeroTo(value - 1 ) + " " + value;
        }
    }

    private static String createMonotoneSequence(int from, int to) {
       int order = (from <= to) ? -1 : 1;
            if (from == to) {
                return ""+from;
            }
            else{
                return createMonotoneSequence(from , to + order )+ " " + to;
            }
    }
}
