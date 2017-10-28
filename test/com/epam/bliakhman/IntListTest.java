package com.epam.bliakhman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntListTest {

    @Test
    void defaultConstructorTest() {
        IntList list = new IntList();
        assertEquals(0, list.size());
        assertEquals(-1,list.indexOf(5));
        assertArrayEquals(new int[0],list.toArray ());

    }
    @Test
    void nonDefaultConstructorTest() {
        IntList list = new IntList(100);
        assertEquals(0, list.size());
        assertEquals(-1,list.indexOf(5));
        assertArrayEquals(new int[0],list.toArray ());

    }
    @Test
    void add() {
        IntList list = new IntList()  ;
        for (int i = 0; i <50 ; i++) {
            list.add(i);
        }
        assertEquals(9,list.get(9));
    }

    @Test
    void addToIndex() {
        IntList list = new IntList()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.add(3,0);
        list.add(2,1);
        list.add(1,2);
        assertArrayEquals(new int[]{3,2,1,0,1,2},list.toArray ());
    }

    @Test
    void set() {
        IntList list = new IntList()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }
        list.set(5,1);
        list.set(5,3);
        assertEquals(5,list.get(1));
        assertEquals(1,list.indexOf(5));
        assertEquals(3,list.lastIndexOf(5));
        assertEquals(-1,list.lastIndexOf(10));
    }

    @Test
    void remove(){
        IntList list = new IntList()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(i);
        }
       assertFalse(list.remove(5));
       assertTrue(list.remove(3));
    }

    @Test
    void removeAllAll() {
        IntList list = new IntList()  ;
        for (int i = 0; i <5 ; i++) {
            list.add(5);
        }
        list.removeAll(5);
        assertArrayEquals(new int[0],list.toArray ());
    }

    @Test
    void removeAllNothing() {
        IntList list = new IntList()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.removeAll(6);
        assertArrayEquals(new int[]{0,1,2},list.toArray ());
    }

    @Test
    void removePart() {
        IntList list = new IntList()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.removeAll(1);
        assertArrayEquals(new int[]{0,2},list.toArray ());
    }

    @Test
    void trimToSize() {
        IntList list = new IntList()  ;
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        list.trimToSize();
        assertEquals(3,list.getInternalSize());

    }

    @Test
    void testToString() {
        IntList list = new IntList();
        assertEquals("[]",list.toString());
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        assertEquals("[0, 1, 2]",list.toString());
    }
}