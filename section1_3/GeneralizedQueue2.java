package section1_3;

import java.util.Iterator;

public class GeneralizedQueue2<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        Node next;
        T item;
    }

    public GeneralizedQueue2() {

    }

    public boolean isEmpty() {return size == 0;}

    public void insert(T item) {
        if (isEmpty()) last = first;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public T delete(int k) {
        //int step = 1;
        if (k == 1) {
            T item = first.item;
            first = first.next;
            return item;
        }

        Node x;
        for (x = first; k > 2 ; x = x.next) {
            k--;
        }
        T item = x.next.item;
        x.next = x.next.next;

        return item;
    }

    public Iterator<T> iterator() {
        return new GenQueueIterator();
    }

    private class GenQueueIterator implements Iterator<T>{
        private Node current = first;

        public boolean hasNext() {return current != null;}

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        GeneralizedQueue2<Integer> test = new GeneralizedQueue2<>();
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);

        test.forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.println(test.delete(5));
        test.forEach(s -> System.out.print(s + " "));




    }



}
