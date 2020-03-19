package com.fesine.data01;

import java.util.Iterator;

/**
 *
 * Created by Fesine on 2016/5/5.
 */
public class MyArrayList02<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    public AnyType[] theItems;

    public MyArrayList02() {
        clear();
    }

    private void clear() {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }
    public AnyType set(int idx,AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * +1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public  AnyType remove(int idx) {
        AnyType removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator<AnyType>(this);
    }
}

class ArrayListIterator<AnyType> implements Iterator<AnyType>{

    private int current = 0;

    private MyArrayList02<AnyType> theList;

    public ArrayListIterator(MyArrayList02<AnyType> list) {
        this.theList = list;
    }

    @Override
    public boolean hasNext() {
        return current < theList.size();
    }

    @Override
    public AnyType next() {
        return theList.theItems[current++];
    }

    @Override
    public void remove() {
        theList.remove(--current);
    }
}
