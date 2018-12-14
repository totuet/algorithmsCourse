package section1_3;

//basic Queue implementation

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Node next;
        Item item;
    }

    /*
    1.3.41 Copy a queue. Create a new constructor so that Queue<Item> r = new Queue<Item>(q);
    makes r a reference to a new and independent copy of the queue q. You should be able
    to push and pop from either q or r without influencing the other.
    Hint : Delete all of the elements from q and add these elements to both q and r.
     */

    public Queue() {}

    public Queue(Queue queue) {
        for (int i = 0; i < queue.size(); i++) {
            Item temp = (Item)queue.dequeue();
            enqueue(temp);
            queue.enqueue(temp);
        }


    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue (Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())  first = last;
        else            oldlast.next = last;
        N++;

    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() { }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> firstQ = new Queue<>();
        for (int i = 0; i < 10; i++) {
            firstQ.enqueue(i + 1);
        }
        System.out.println(firstQ);

        Queue<Integer> secondQ = new Queue<>(firstQ);
        System.out.println("first");
        System.out.println(firstQ);
        firstQ.forEach(System.out::print);
        System.out.println("\nsecond");
        secondQ.forEach(System.out::print);

    }
}
