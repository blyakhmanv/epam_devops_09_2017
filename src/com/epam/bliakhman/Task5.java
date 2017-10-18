package com.epam.bliakhman;

import java.util.*;

public class Task5 {

    public enum vowels {a, A, e,E,i,I,o,O,u,U,y,Y};

    public static void main(String[] args) {

        int result =0;

        //create alphabet arrayList
        ArrayList<Character> alpha =new ArrayList<Character>(52);
        for (int i = 0; i < 26; i++) {
            alpha.add((char) (97 + i));
        }
        for (int i = 0; i < 26; i++) {
            alpha.add((char) (65 + i));
        }

        //create ArrayList of vowels
        ArrayList<Character> vowels =new ArrayList<Character>(Arrays.asList('a','A','e','E','i','I','o','O','u','U','y','Y'));

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

        //build Array with extended information about words
        getVowelsConsonantNumbers[] wordExtenededArray = new getVowelsConsonantNumbers[wordArray.length];
        for (int i = 0; i <wordArray.length ; i++) {
            wordExtenededArray[i]= new getVowelsConsonantNumbers(wordArray[i],alpha,vowels);
        }

        //find all Eng words where countVowles = countConsonants
        for (getVowelsConsonantNumbers getVowelsConsonantNumbers : wordExtenededArray) {
           if (getVowelsConsonantNumbers.isEng & Objects.equals(getVowelsConsonantNumbers.consonantCount, getVowelsConsonantNumbers.vowelsCount)){
              result++;
           }
        }
        System.out.println("Number of words: "+result);
    }
}


class getVowelsConsonantNumbers {
    private String word;
    Integer vowelsCount = 0;
    Integer consonantCount = 0;
    boolean isEng = true;

    getVowelsConsonantNumbers(String word, ArrayList alpha, ArrayList vowels){
        this.word = word;
        for (Character character : word.toCharArray()) {
            if (!(alpha.contains(character))) {
                isEng = false;
                break;
            }
            else {
               if (vowels.contains(character)) {
                   vowelsCount++;
               }
               else {
                   consonantCount++;
               }

            }
        }

    }

    @Override
    public String toString() {
        return word+":"+isEng+":"+vowelsCount+":"+consonantCount;
    }
}