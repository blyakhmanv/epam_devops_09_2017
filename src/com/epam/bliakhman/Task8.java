package com.epam.bliakhman;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Task8 {

    public static void main (String[] args) {
        System.out.println ( intPolindromFinder(new String[] {"aa", "bbb", "123", "121", "qqq", "2"}));

    }
    public static String  intPolindromFinder (String[] args) {
        String result = null;
        for ( String arg : args ) {
           if (isNumericPolindrom (arg)) {
               result = arg;
           }
        }
      return result;
    }

    public static Boolean isNumericPolindrom (String str) {
        for ( int i = 0 ; i < (str.length() /2 + 1)  ; i++ ) {
            if (!( Character.isDigit(str.charAt ( i ) ) &
                   Character.isDigit(str.charAt ( str.length () - i -1 ) ) &
                   str.charAt ( i )== str.charAt ( str.length () - i -1 ) )){
              return false;
            }
        }
        return true;
    }
}

