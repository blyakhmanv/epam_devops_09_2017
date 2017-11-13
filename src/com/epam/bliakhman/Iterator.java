package com.epam.bliakhman;

public interface Iterator<T> {

    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();
}
