package com.epam.bliakhman;


import java.util.Arrays;


public class ArrayGenericList<T> implements GenericList<T> {

    public static final int DEFAULTSIZE = 16;
    private Object[] arr;
    private int currentLength;

    public ArrayGenericList (){
        this(DEFAULTSIZE);
    }

    public ArrayGenericList (int size) {
        arr = new Object[size];
    }

    private void extendIfNeeded(){
        if (currentLength == arr.length) {
            arr = Arrays.copyOf(arr, (int)(currentLength*1.5));
        }
    }

    @Override
    public void add(T value) {
       this.add(value, currentLength);
    }

    @Override
    public void add(T value, int index) {
        extendIfNeeded();
        System.arraycopy(arr, index, arr, index+1, currentLength-index );
        arr[index] = value;
        currentLength++;
    }

    @Override
    public void set(T value, int index){
        arr[index]=value;
    }

    @Override
    public boolean remove(T value) {
        int index = this.indexOf(value);
        if (index == -1) {
            return false;
        }
        this.removeFrom(index);
        return true;
    }

    @Override
    public boolean removeAll(T value) {
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
    }

    @Override
    public T removeFrom(int index) {
        T item = (T) arr[index];
        System.arraycopy(arr, index+1, arr, index, currentLength-index-1);
        currentLength--;
        return item;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T[] toArray () {
       return (T[])Arrays.copyOf(arr, currentLength);
    }

    @Override
    public int size() {
        return currentLength;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < currentLength; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = currentLength-1; i >= 0 ; i--) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    public void trimToSize() {
        arr = Arrays.copyOf(arr, currentLength);
    }

    public int getInternalSize() {
        return arr.length;
    }

    @Override
    public String toString(){
        if (currentLength == 0)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < currentLength-1 ; i++) {
            b.append(arr[i]).append (", ");
            }
        return b.append(arr[currentLength-1]).append ("]").toString();
    }

    @Override
    public Iterator <T> getIterator () {
        return new InnerIterator ();
    }

    private class InnerIterator implements  Iterator<T>{

        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public T next() {
            return (T) arr[currentIndex++];
        }
    }

}
