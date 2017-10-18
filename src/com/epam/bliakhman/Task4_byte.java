package com.epam.bliakhman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4_byte {


    public static void main(String[] args) {

        //create alphabet array
        ArrayList<Character> alpha =new ArrayList<Character>(52);
            for (int i = 0; i < 26; i++) {
                alpha.add((char) (97 + i));
                }
            for (int i = 0; i < 26; i++) {
                alpha.add((char) (65 + i));
                }
        System.out.println(Arrays.toString(alpha.toArray()));
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
            WordLetterCountByte[] wordLetterCountArray = new WordLetterCountByte[wordArray.length];
            for (int i = 0; i <wordArray.length ; i++) {
                wordLetterCountArray[i] = new WordLetterCountByte(wordArray[i],alpha);
            }

            //Print sorted Array
            Arrays.sort(wordLetterCountArray);
            System.out.println(Arrays.toString(wordLetterCountArray));
        }
    }

    class WordLetterCountByte implements Comparable<WordLetterCountByte> {
        private String word;
        private Integer lettercount;

        WordLetterCountByte (String word,ArrayList alpha) {
            this.word = word;
            long byteor = 0;
            for (char character : word.toCharArray()) {
               byteor |= 1 << alpha.indexOf(character);
            }
            lettercount=Long.bitCount(byteor);
        }

        @Override
        public String toString() {
            return word+":"+lettercount;
        }

        @Override
        public int compareTo(WordLetterCountByte o) {
            return Integer.compare(lettercount, o.lettercount);
        }
    }
