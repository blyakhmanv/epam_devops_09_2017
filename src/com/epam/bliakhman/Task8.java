package com.epam.bliakhman;

public class Task8 {

    public static void main (String[] args) {
        System.out.println ( intPolindromFinder(new String[] {"aa", "bbb", "123", "121", "qqq", "2"}));

    }
    public static String  intPolindromFinder (String[] args) {
        String result = null;
        for ( int i = 0 ; i < args.length ; i++ ) {
            if (args[i].matches( "[0-9]+" )) {
                String reverseString = new StringBuilder (args[i]).reverse().toString();
                if (args[i].equals ( reverseString )) {
                    result = args[i];
                }
            }
        }
      return result;
    }
}

