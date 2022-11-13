package ru.dankras.myCollections;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private Object[] elementData;
    private int size;

    @Override
    public void add(E e) {
        if (size == capacity) {
            copyArrayAndUpCapacity();
        }
        elementData[size] = e;
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            copyArrayAndUpCapacity();
        }
        moveElements(index);
        elementData[index] = e;
        size++;
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    @Override
    public void remove(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;

    }

    public int size() {
        return size;
    }

    private void copyArrayAndUpCapacity() {
        capacity *= 2;
        Object[] newElementData = new Object[capacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
        newElementData = null;

    }

    private void moveElements(int index) {
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }

    }
}
