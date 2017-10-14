package com.epam.bliakhman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Task4_byte {


    public static void main(String[] args) {

            //create HashMap of all characters with power of 2 as value
            HashMap<Character, Long> alpha = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                alpha.put(((char) (97 + i)), (long) Math.pow(2, i));
            }
            for (int i = 0; i < 26; i++) {
                alpha.put(((char) (65 + i)), (long) Math.pow(2, i + 26));
            }
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

        WordLetterCountByte (String word,HashMap<Character,Long> alpha) {
            this.word = word;
            long byteor = 0;
            for (Character character : word.toCharArray()) {
                byteor |= alpha.get(character);
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
