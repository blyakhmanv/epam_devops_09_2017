package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayGenericListTest {

    @Test
    void defaultConstructorTest() {
        ArrayGenericList<Integer> list = new ArrayGenericList<> ();
        assertEquals(0, list.size());
        assertEquals(-1,list.indexOf(5));
        assertArrayEquals(new Integer[0],list.toArray ());

    }
    @Test
    void nonDefaultConstructorTest() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> (100);
        assertEquals(0, list.size());
        assertEquals(-1,list.indexOf(5));
        assertArrayEquals(new Integer[0],list.toArray ());

    }
    @Test
    void add() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <50 ; i++) {
            list.add(i);
        }
        assertEquals((Integer)9,list.get(9));
    }

    @Test
    void addToIndex() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.add(3,0);
        list.add(2,1);
        list.add(1,2);
        assertArrayEquals(new Integer[]{3,2,1,0,1,2},list.toArray ());
    }

    @Test
    void set() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }
        list.set(5,1);
        list.set(5,3);
        assertEquals((Integer)5,list.get(1));
        assertEquals(1,list.indexOf(5));
        assertEquals(3,list.lastIndexOf(5));
        assertEquals(-1,list.lastIndexOf(10));
    }

    @Test
    void remove(){
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }
       assertFalse(list.remove(5));
       assertTrue(list.remove(3));
    }

    @Test
    void removeAllAll() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(5);
        }
        list.removeAll(5);
        assertArrayEquals(new Integer[0],list.toArray ());
    }

    @Test
    void removeAllNothing() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.removeAll(6);
        assertArrayEquals(new Integer[]{0,1,2},list.toArray ());
    }

    @Test
    void removePart() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.removeAll(1);
        assertArrayEquals(new Integer[]{0,2},list.toArray ());
    }

    @Test
    void trimToSize() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.trimToSize();
        assertEquals(3,list.getInternalSize());

    }

    @Test
    void testToString() {
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        assertEquals("[]",list.toString());
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        assertEquals("[0, 1, 2]",list.toString());
    }

    @Test
    void testIterator() {
        int counter = 0;
        ArrayGenericList<Integer> list = new ArrayGenericList <> ()  ;
        assertEquals("[]",list.toString());
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.getIterator ();
            while (iterator.hasNext()) {
                iterator.next ();
                counter++;
        }
        assertEquals ( 3, counter );
    }
}