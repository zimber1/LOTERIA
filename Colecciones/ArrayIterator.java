package Colecciones;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private int count;
    private int current;
    private T[] items;

    public ArrayIterator(int size, T[] collection) {
        this.count = size;
        this.current = 0;
        this.items = collection;
    }

    @Override
    public boolean hasNext() {
        return current < count;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[current++];
    }
}
