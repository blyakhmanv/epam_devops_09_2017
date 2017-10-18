package com.epam.bliakhman;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        procedureStyleSolution(names,times);
        oopSolution(names,times);
       }

    private static void oopSolution(String[] names, int[] times) {

        Record[] records = new Record[names.length];
        for (int i = 0; i <names.length ; i++) {
           records[i]= new Record(names[i],times[i]);
        }

        System.out.println(Arrays.toString(records));

        Arrays.sort(records);
        System.out.println(Arrays.toString(records));
    }

    private static void procedureStyleSolution(String[] names, int[] times) {
        String [] SumArray = new String[times.length];
        for (int i = 0; i <times.length ; i++) {
              SumArray[i]=String.valueOf(times[i])+"_"+names[i];
        }
        Arrays.sort(SumArray);
        System.out.println("Winners are:");
        for (int i = 0; i <3 ; i++) {
            String[] parts = SumArray[i].split("_");
            System.out.println((i+1)+" place "+parts[1]+" with result "+parts[0]);
        }
    }


}

class Record implements Comparable<Record> {
    String name;
    int time;

    Record(String name, int time){
      this.name=name;
      this.time=time;

    }

    @Override
    public String toString() {
        return name+":"+time;
    }

    @Override
    public int compareTo(Record other) {
        return Integer.compare(time,other.time);
    }
}

