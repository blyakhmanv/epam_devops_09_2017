package com.epam.bliakhman;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Task3 {

    public static void main(String[] args) {
        Integer a;
        try {
           a =  Integer.valueOf(args[0]);
       } catch (NumberFormatException |  ArrayIndexOutOfBoundsException  ex ) {
            System.out.println(ex);
            return;
        }

        switch (a % 10){
            case 0: case 1: case 2: case 3:
                System.out.println("Green");
                break;
            case 4: case 5:
                System.out.println("Yellow");
                break;
            default:
                System.out.println("Red");
            }
        }



    }

