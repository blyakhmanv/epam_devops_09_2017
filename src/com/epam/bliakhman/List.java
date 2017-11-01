package com.epam.bliakhman;

public interface List <T> {

    void add (T value);

    void add(T value, int index);

    void set(T value, int index);

    boolean remove(T value);

    boolean removeAll (T value);

    T removeFrom(int index);

    T get(int index);

    Object[] toArray ();

    int size();

    int indexOf(T value);

    int lastIndexOf(T value);
}
