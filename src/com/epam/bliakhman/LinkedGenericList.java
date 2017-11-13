package com.epam.bliakhman;

import com.epam.se2.lesson14.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringJoiner;

public class LinkedGenericList<T> implements GenericList<T>{
    Node<T> firstNode;
    Node<T> lastNode;
    int currentLength;

    LinkedGenericList(){
        lastNode = new Node<>(null, null, null);
        firstNode = new Node<>(null,null,lastNode);
        lastNode.previous=firstNode;


    }

    private Node<T> getNode(int index) {
        if (index == -1) return firstNode;
        if (index == 0) return firstNode.getNext ( );
        if (index == currentLength) return lastNode.getPrevious ();
        Node<T> resultNode = firstNode.getNext ();
        for ( int i = 0 ; i <index  ; i++ ) {
            resultNode = resultNode.getNext ();
        }
        return resultNode;
    }

    @Override
    public void add (T value) {
        add(value,currentLength);
    }

    @Override
    public void add (T value, int index) {
        Node<T> tempPreviousNode = getNode ( index - 1 );
        Node<T> tempNextNode = tempPreviousNode.getNext ();
        Node<T> newNode = new Node<>(tempPreviousNode, value, tempNextNode);
        tempPreviousNode.setNext ( newNode );
        tempNextNode.setPrevious ( newNode );
        currentLength++;
    }

    @Override
    public void set (T value, int index) {
        getNode ( index ).setValue ( value );

    }

    @Override
    public boolean remove (T value) {
        int index = this.indexOf ( value );
        if ( index > -1 ){
            this.removeFrom ( index );
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll (T value) {
        boolean isFound ;
        int index = this.indexOf ( value );
        isFound = (index > -1)? true : false;
        while (index > -1) {
           this.removeFrom ( index );
           index = this.indexOf ( value );

        }
        return isFound;
    }

    @Override
    public T removeFrom (int index) {
        Node<T> removeNode = getNode ( index );
        removeNode.getPrevious ().setNext ( removeNode.getNext () );
        removeNode.getNext ().setPrevious ( removeNode.getPrevious () );
        currentLength--;
        return  removeNode.getValue ();
    }

    @Override
    public T get (int index) {
        return getNode ( index ).getValue ();
    }



    @Override
    public T[] toArray () {
        T[] arr = (T[])new Object[currentLength];
        if (currentLength == 0) {
            return arr;
        }
        int index = 0 ;
        Iterator<T> iter = this.getIterator ();
        while (iter.hasNext ()) {
            arr[index]=iter.next ();
            index++;
        }
        return  arr;
    }

    @Override
    public int size () {
        return currentLength;
    }

    @Override
    public int indexOf (T value) {
        if (currentLength == 0) {
            return -1;
        }
        Iterator<T> iter = this.getIterator ();
        int index=0;
        while (iter.hasNext ()) {
            if ( iter.next() == value) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf (T value) {
        Iterator<T> iter = this.getIterator ();
        int index = this.size () + 1;
        int lastIndex = -1;
        while (iter.hasPrevious ()) {
            if ( iter.previous () == value) {
                lastIndex = index;
            }
            index--;
        }
        return lastIndex;
    }


    @Override
    public String toString() {
        if (currentLength == 0) return "[]";
        StringBuilder sb = new StringBuilder ("[");
        String prefix = "";
        Iterator<T> iter = this.getIterator ();
        while (iter.hasNext ()) {
            sb.append(prefix);
            prefix = ", ";
            sb.append(iter.next ());
        }
      return sb.append("]").toString ();
    }

    @Override
    public Iterator <T> getIterator () {
        return new ListIterator ();
    }


    private class ListIterator implements  Iterator<T>{

        private Node<T> currentNode;

        @Override
        public boolean hasNext() {
            return currentNode != lastNode.getPrevious ();
        }

        @Override
        public boolean hasPrevious () {
            return currentNode != firstNode.getNext ();
        }

        @Override
        public T next() {
            if (currentNode == null) {currentNode = firstNode;}
            currentNode = currentNode.getNext ();
            return currentNode.getValue ();
        }

        @Override
        public T previous () {
            if (currentNode == null) {currentNode = lastNode;}
            currentNode = currentNode.getPrevious ();
            return currentNode.getValue ();
        }
    }

    @Setter
    @Getter
    private class Node<T> {
        Node<T> previous;
        Node<T> next;
        T value;

        Node(Node<T> previous, T value, Node<T> next ) {
            this.previous = previous;
            this.value = value;
            this.next = next;

        }
    }
}
