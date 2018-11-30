package section1_3;

//Write a Queue implementation that uses a circular linked list, which is the same
//as a linked list except that no links are null and the value of last.next is first
// whenever the list is not empty. Keep only one Node instance variable (last).

import java.util.Iterator;

public class QueueCircular<Item> implements Iterable<Item> {
    private Node last;
    private int N;

    private class Node{
        Node next;
        Item item;
    }

    public boolean isEmpty() {return N == 0;}

    public int size() {return N;}

    public void enqueu(Item item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = last;
            N++;
            return;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;

            if (size() == 1) {
                last.next = oldLast;
                oldLast.next = last;
                N++;
            } else {
                last.next = oldLast.next;
                oldLast.next = last;
                N++;
            }
        }

    }

    public Item dequeu() {
        if (isEmpty()) return null;

        Item item = last.next.item;

        if (N == 1) last = null;
        else last.next = last.next.next;

        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        Node current;
        int count = 0;

        public ListIterator() {
            if ((last != null) && (N > 0)) {
                current = last.next;
            } else {
                current = last;
            }
        }

        public boolean hasNext() {
            return count < N;
        }

        public Item next() {
            count++;
            Item item = current.item;
            current = current.next;
            return item;
        }



    }

    public static void main(String[] args) {
        QueueCircular<Integer> list = new QueueCircular<>();

        list.enqueu(3);
        list.enqueu(4);
        list.enqueu(5);
        list.enqueu(6);
        list.enqueu(7);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.dequeu();
        list.dequeu();

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


}
