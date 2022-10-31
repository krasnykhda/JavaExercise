package ru.dankras.myCollections;

public class Node<E> {
    Node<E> next;
    Node<E> prev;
    E element;

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node(Object element) {
        this.element = (E) element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public E getElement() {
        return element;
    }
}
