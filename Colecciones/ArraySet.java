package Colecciones;

import java.util.Iterator;
import java.util.Random;

public class ArraySet<T> implements SetADT<T>, Iterable<T> {

    private static final Random rand = new Random();
    private static final int DEFAULT_CAPACITY = 50;
    private int count;
    private T[] contents;

    public ArraySet() {
        count = 0;
        contents = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public ArraySet(int initialCapacity) {
        count = 0;
        contents = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public void add(T element) {
        if (!contains(element)) {
            if (count == contents.length) {
                expandCapacity();
            }
            contents[count] = element;
            count++;
        }
    }

    @Override
    public void addAll(SetADT<T> set) {
        Iterator<T> scan = set.iterator();
        while (scan.hasNext()) {
            add(scan.next());
        }
    }

    @Override
    public T removeRandom() {
        if (isEmpty()) {
            throw new IllegalStateException("El conjunto está vacío.");
        }
        int randomIndex = rand.nextInt(count);
        T result = contents[randomIndex];
        contents[randomIndex] = contents[count - 1];
        contents[count - 1] = null;
        count--;
        return result;
    }

    @Override
    public T remove(T element) {
        int index = find(element);
        if (index == -1) {
            throw new IllegalArgumentException("Elemento no encontrado.");
        }
        T result = contents[index];
        contents[index] = contents[count - 1];
        contents[count - 1] = null;
        count--;
        return result;
    }

    @Override
    public boolean contains(T target) {
        return find(target) != -1;
    }

    @Override
    public boolean equals(SetADT<T> set) {
        if (size() != set.size()) {
            return false;
        }

        Iterator<T> scan = set.iterator();
        while (scan.hasNext()) {
            if (!contains(scan.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(count, contents);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(contents[i].toString()).append("\n");
        }
        return result.toString();
    }

    private void expandCapacity() {
        T[] larger = (T[]) (new Object[contents.length * 2]);
        System.arraycopy(contents, 0, larger, 0, contents.length);
        contents = larger;
    }

    private int find(T target) {
        for (int i = 0; i < count; i++) {
            if (contents[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
