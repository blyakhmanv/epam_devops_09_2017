package com.epam.bliakhman;

public class Task10 {

    public static void main (String[] args) {

    }

    public static boolean isPowerOfTwo(long value) {
        long powerofTwo = 1;

        for ( int i = 1 ; i < 32 ; i++ ) {
            if (powerofTwo == value) return true;
            else powerofTwo <<= 1;
        }
        return false;
    }
}


