package com.epam.bliakhman;

public class LinkedGenericList<T> implements GenericList<T>{
    Node<T> firstNode;
    Node<T> lastNode;
    int currentLength;

    LinkedGenericList(){
        lastNode = new Node<>(firstNode, null, null);
        firstNode = new Node<>(null,null,lastNode);

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
        return false;
    }

    @Override
    public boolean removeAll (T value) {
        return false;
    }

    @Override
    public T removeFrom (int index) {
        Node<T> removeNode = getNode ( index );
        removeNode.getPrevious ().setNext ( removeNode.getNext () );
        removeNode.getNext ().setPrevious ( removeNode.getPrevious () );
        return  removeNode.getValue ();
    }

    @Override
    public T get (int index) {
        return getNode ( index ).getValue ();
    }



    @Override
    public Object[] toArray () {
        return new Object[ 0 ];
    }

    @Override
    public int size () {
        return currentLength;
    }

    @Override
    public int indexOf (T value) {
        return 0;
    }

    @Override
    public int lastIndexOf (T value) {
        return 0;
    }


    @Override
    public String toString() {
        return null;
    }

    @Override
    public Iterator <T> getIterator () {
        return null;
    }

    private class Node<T> {
        Node<T> previous;
        Node<T> next;
        T value;

        Node(Node<T> previous, T value, Node<T> next ) {
            this.previous = previous;
            this.value = value;
            this.next = next;

        }

        public Node <T> getPrevious () {
            return previous;
        }

        public void setPrevious (Node <T> previous) {
            this.previous = previous;
        }

        public void setNext (Node <T> next) {
            this.next = next;
        }

        public Node <T> getNext () {
            return next;
        }

        public T getValue () {
            return value;
        }

        public void setValue (T value) {
            this.value = value;
        }
    }

    public static void main (String[] args) {
        LinkedGenericList<String> llist = new LinkedGenericList <> ();
        llist.add ( "1" );
        llist.add ( "2" );
        llist.add ( "3" );
        llist.add("5",3);
        llist.add ( "4",2 );
        llist.set ( "6",1 );
        System.out.println (llist.get ( 0 ) );
        System.out.println (llist.get (1 ) );
        System.out.println (llist.get ( 2 ) );
        System.out.println (llist.get ( 3 ) );
        System.out.println (llist.get ( 4 ) );

        System.out.println ( "Removed " +llist.removeFrom (3 ) );

        System.out.println (llist.get ( 0 ) );
        System.out.println (llist.get (1 ) );
        System.out.println (llist.get ( 2 ) );
        System.out.println (llist.get ( 3 ) );
        System.out.println (llist.get ( 4 ) );


    }
}
