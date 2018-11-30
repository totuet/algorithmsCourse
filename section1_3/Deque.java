package section1_3;


/*
 Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
a queue but supports adding and removing items at both ends.
A deque stores a collection of items and supports the following API:
 */

import java.util.Iterator;

public class Deque<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node next;
        Node previous;
        T item;
    }

    public boolean isEmpty() {return size == 0;}

    public int getSize() {return size;}

    public void pushLeft(T item) {
        if (isEmpty()) {
            head = new Node();
            head.item = item;
            size++;
            tail = head;
            return;
        }
        Node oldHead = head;
        head = new Node();
        head.next = oldHead;
        oldHead.previous = head;
        head.item = item;

        size++;

    }

    public T popLeft() {
        T item = head.item;
        if (isEmpty()) return null;
        if (size == 1) head = tail = null;
        else {

            head = head.next;
            head.previous = null;
        }
        size--;
        return item;
    }

    public void pushRight(T item) {
        if (isEmpty()) head = tail;

        Node oldTail = tail;
        tail = new Node();
        tail.previous = oldTail;
        oldTail.next = tail;
        tail.item = item;
        size++;
    }

    public T popRight() {
        if (isEmpty()) return null;
        T item = tail.item;
        if (size == 1) { tail = head = null;}
        else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return item;
    }





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
