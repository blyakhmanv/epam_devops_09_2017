package com.epam.bliakhman;

import java.lang.reflect.Array;

public class Task17 {
    public static void main( String args[] ) {
        Printer printer = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        printer.printArray(intArray);
        printer.printArray(stringArray);
    }
}

/**
 * Требуется реализовать метод printArray, который принимает массив объектов и выводит каждый элемент с новой строки.
 */
class Printer {

    public  <T>   void printArray ( T[] genericarray) {
        for ( T t : genericarray ) {
            System.out.println (t.toString () );
        }

    }
}