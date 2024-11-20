package Colecciones;

import java.util.Iterator;

public interface SetADT<T> {

    void add(T element);

    void addAll(SetADT<T> set);

    T removeRandom();

    T remove(T element);

    boolean contains(T target);

    boolean equals(SetADT<T> set);

    boolean isEmpty();

    int size();

    Iterator<T> iterator();

    String toString();
}
