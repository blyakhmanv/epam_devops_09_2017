package com.epam.bliakhman;

public class FirstExample {

    public static void main(String[] args) {

        System.out.printf("Count: %d%n", args.length);

        float len = 0;

        for  (String str  : args) {
        len+=str.length();
         }

        System.out.printf("AVG : "+(float)len/args.length );


    }
}
