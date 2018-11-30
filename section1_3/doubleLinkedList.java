package section1_3;

/*
Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item).

Then implement static methods for the following tasks:
            -insert at the beginning,
            -insert at the end,
            -remove from the beginning,
            -remove from the end,
            -insert before a given node,
            -insert after a given node, and
            -remove a given node
 */

import java.util.Iterator;

public class doubleLinkedList<T> implements Iterable<T> {

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

    public void addHead(T item) {
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

    public T removeHead() {
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

    public void addTail(T item) {
        if (isEmpty()) head = tail;

        Node oldTail = tail;
        tail = new Node();
        tail.previous = oldTail;
        oldTail.next = tail;
        tail.item = item;
        size++;
    }

    public T removeTail() {
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

    public static void main(String[] args) {
        doubleLinkedList<Integer> list = new doubleLinkedList<>();
        list.addHead(4);


        list.removeHead();

        list.addHead(3);
        list.addTail(4);

        list.removeHead();


        list.forEach(s -> System.out.print(s + " "));
    }

}
