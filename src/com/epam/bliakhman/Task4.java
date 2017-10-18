package com.epam.bliakhman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        //Get user input
        String userinput;
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a string: ");
            userinput = reader.nextLine();
            if (userinput.length() > 0)
                break;
        }
        reader.close();


        //Split string into arry by space
        String[] wordArray = userinput.split("\\s+");

        //Create array of WordLetterCount objects
        WordLetterCount[] wordLetterCountArray = new WordLetterCount[wordArray.length];
        for (int i = 0; i <wordArray.length ; i++) {
            wordLetterCountArray[i] = new WordLetterCount(wordArray[i]);
        }

        //Print sorted Array
        Arrays.sort(wordLetterCountArray);
        System.out.println(Arrays.toString(wordLetterCountArray));
    }
}

 class WordLetterCount implements Comparable<WordLetterCount> {
     private String word;
     private Integer lettercount;

     WordLetterCount (String word) {
         this.word = word;
         HashSet<Character> temphash = new HashSet<>();
         for (Character letter : word.toCharArray() ) {
            temphash.add(letter);
         }
         lettercount=temphash.size();
     }

     @Override
     public String toString() {
         return word+":"+lettercount;
     }

     @Override
     public int compareTo(WordLetterCount o) {
         return Integer.compare(lettercount, o.lettercount);
     }
 }