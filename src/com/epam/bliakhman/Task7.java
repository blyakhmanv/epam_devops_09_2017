package com.epam.bliakhman;

import java.util.Arrays;

public class Task7 {
  public static String main(String[] args) {

    NewOrderedString[] strings = new NewOrderedString[args.length];
    for ( int i = 0 ; i <args.length  ; i++ ) {
      strings[i] = new NewOrderedString ( args[i] );
    }
    Arrays.sort ( strings );
    return Arrays.toString ( strings);

  }
}

class NewOrderedString implements Comparable<NewOrderedString> {

    String str ;

    public NewOrderedString (String str) {
        this.str = str;
    }

    @Override
    public int compareTo(NewOrderedString other) {
        if ( this.str.length ()!= other.str.length ()) {
            return Integer.compare(str.length (),other.str.length ());
        }
        else {
            return str.compareTo ( other.str );
        }
    }

    @Override
    public String toString() {
        return str;
    }
}