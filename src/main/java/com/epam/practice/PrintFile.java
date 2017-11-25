package main.java.com.epam.practice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PrintFile {

    public static void main (String[] args) {
        String path = new String ("site/Гостиница «Волхов» – официальный сайт_files/04.jpg");
        StringBuilder result = new StringBuilder (  );
        ClassLoader classloader = ClassLoader.getSystemClassLoader ();
        try {
            BufferedInputStream bis = new BufferedInputStream ( classloader.getResourceAsStream(path));
           while (bis.available ()>0) {
               result = result.append (  (char)bis.read ( )) ;
           }

        } catch (IOException e) {
            result.append ( "File not found");
        }
        System.out.println (result );
    }

    }

