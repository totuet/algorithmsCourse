package section1_3;

/*
Steque. A stack-ended queue or steque is a data type that supports push, pop, and
enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */

import java.util.Iterator;

public class Steque<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node next;
        T item;
    }

    public boolean isEmpty() {return size == 0;}

    public int getSize() {return size;}

    public void push(T item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        if (isEmpty()) tail = head;
        if (size == 1) tail = oldHead;
        size++;
    }

    public T pop() {
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public void enqueue(T item) {
        if (isEmpty()) {
            tail = new Node();
            tail.item = item;
            size++;
            head = tail;

        } else {
            Node oldTail = tail;
            tail = new Node();
            oldTail.next = tail;
            tail.item = item;
            if (isEmpty()) head = tail;
            size++;
        }
    }

    /*
    Write a function that takes the first Node in a linked list as argument and
    (destructively) reverses the list, returning the first Node in the result
     */



    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node current = head;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (isEmpty()) return null;
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
