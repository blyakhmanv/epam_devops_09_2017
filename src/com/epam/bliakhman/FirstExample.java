package com.epam.bliakhman;

public class FirstExample {

    public static void main(String[] args) {

        System.out.println("Count: "+args.length);

        float len = 0;

        for  (String str  : args) {
        len+=str.length();
         }

        System.out.println("AVG : "+(float)len/args.length );


    }
}
