package com.epam.bliakhman;

public class IntList {

    private final int[] arr;
    private int currentlength=0;

    public IntList(){
        arr = new int[16];
    }

    public IntList (int size) {
        arr = new int[size];

    }

    public void add(int value) {
        //TODO add element into the list as the last item
    }

    public void add(int value, int index) {
        //TODO add element into the index position
    }

    public void set(int value, int index){
        //TODO replace item with value in the index position
    }

    public boolean remove(int value) {
        //TODO find and delete first occurence of item value if exists and return true otherwise  return false
        return false;
    }

    public boolean removeall(int value) {
        //TODO find and delete all occurences of item value if exists and return true otherwise  return false
        return false;
    }
    public int removeFrom(int index) {
        //TODO remove element at position and return the value
        return 0;
    }

    public int get(int index) {
        //TODO return value of item at index
        return 0;
    }

    public int[] toArrary() {
        //TODO return copy of arraylist
        return null;
    }

    public int size() {
        //TODO get realsize of arraylist
        return 0;
    }

    public int indexOf(int value) {
        //TODO find index of element from the beginning
        return -1;
    }

    public int lastIndexOf(int value) {
        //TODO find index of element from the end
        return -1;
    }

    public void trimToSIze() {
        //TODO decrease array size to the currentlengths

    }
}
