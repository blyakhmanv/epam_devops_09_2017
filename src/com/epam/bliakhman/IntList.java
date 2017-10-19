package com.epam.bliakhman;


import java.util.Arrays;

public class IntList {

    private int[] arr;
    private int currentLength;

    public IntList(){
        this(16);
    }

    public IntList (int size) {
        arr = new int[size];
    }

    private void extendIfNeeded(){
        if (currentLength >= arr.length/2) {
            arr = Arrays.copyOf(arr,currentLength*3);
        }
    }

    public void add(int value) {
       this.add(value, currentLength);
       //TODO add element into the list as the last item -DONE!
    }

    public void add(int value, int index) {
        extendIfNeeded();
        System.arraycopy(arr, index, arr, index+1, currentLength-index );
        arr[index] = value;
        currentLength++;
        //TODO add element into the index position - DONE!
    }

    public void set(int value, int index){
        arr[index]=value;
        //TODO replace item with value in the index position - DONE!
    }

    public boolean remove(int value) {
        int index = this.indexOf(value);
        if (index == -1) {
            return false;
        }
        this.removeFrom(index);
        return true;
        //TODO find and delete first occurence of item value if exists and return true otherwise  return false - DONE!
    }

    public boolean removeAll(int value) {
        if (this.indexOf(value) < 0 ){
            return false;
        }
        int counter = 0;
        for (int i = 0; i < currentLength; i++) {
          if(arr[i] != value) {
              arr[i-counter] = arr[i];
          }
          else {
              counter++;
          }
        }
        currentLength -=counter;
        return true;
        //TODO find and delete all occurences of item value if exists and return true otherwise  return false -DONE!
    }

    public int removeFrom(int index) {
        int item = arr[index];
        System.arraycopy(arr, index+1, arr, index, currentLength-index-1);
        currentLength--;
        return item;
        //TODO remove element at position and return the value -DONE!
    }

    public int get(int index) {
        return arr[index];
        //TODO return value of item at index - DONE!
    }

    public int[] toArrary() {
       return Arrays.copyOf(arr, currentLength);
        //TODO return copy of arraylist - DONE!
    }

    public int size() {
        return currentLength;
        //TODO get realsize of arraylist - DONE!
    }

    public int indexOf(int value) {
        for (int i = 0; i < currentLength; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
        //TODO find index of element from the beginning -DONE!
    }

    public int lastIndexOf(int value) {
        for (int i = currentLength; i >0 ; i--) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
        //TODO find index of element from the end - DONE!
    }

    public void trimToSize() {
        arr = Arrays.copyOf(arr, currentLength);
       //TODO decrease array size to the currentlengths - DONE!
    }

    public int getInternalSize() {
        return arr.length;
    }

    @Override
    public String toString(){
        int[] tempArr = new int[currentLength];
        System.arraycopy(arr, 0, tempArr,0, currentLength);
        return Arrays.toString(tempArr);
    }

    //Test

    public static void main(String[] args) {
        //initiate array
        IntList intList = new IntList();
        for (int i = 0; i < 33 ; i++) {
            intList.add(i);
        }
        //test all methods
        System.out.println(intList);
        intList.add(35,33);
        intList.add(35, 10);
        intList.set(35,11);
        System.out.println(intList);
        System.out.println(intList.get(10));
        System.out.println(Arrays.toString(intList.toArrary()));
        System.out.println(intList.size());
        System.out.println(intList.indexOf(35));
        System.out.println(intList.lastIndexOf(30));
        System.out.println(intList.getInternalSize());
        intList.trimToSize();
        System.out.println(intList.getInternalSize());
        System.out.println(intList);
        System.out.println(intList.removeFrom(34));
        System.out.println(intList.removeFrom(0));
        System.out.println(intList.removeFrom(10));
        System.out.println(intList.remove(66));
        System.out.println(intList.remove(22));
        System.out.println(intList);
        for (int i = 0; i < 24 ; i+=2) {
            intList.set(55,i);
        }
        System.out.println(intList);
        System.out.println(intList.removeAll(66));
        System.out.println(intList.removeAll(55));
        System.out.println(intList);
        System.out.println(intList.getInternalSize());
        System.out.println(intList.size());
    }

}
