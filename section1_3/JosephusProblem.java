package section1_3;

/*
In the Josephus problem from antiquity, N people are in dire
straits and agree to the following strategy to reduce the population. They arrange themselves in
a circle (at positions numbered from 0 to N–1) and proceed around the circle,
eliminating every Mth person until only one person is left. Legend has it that Josephus
figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
takes N and M from the command line and prints out the order in which people are
eliminated (and thus would show Josephus where to sit in the circle).

% java Josephus 7 2
1 3 5 0 4 2 6
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JosephusProblem<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Node next;
        Item item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueu (Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())  first = last;
        else            oldlast.next = last;
        N++;

    }

    public Item dequeu() {
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
        Queue<Integer> que = new Queue<>();
        int numberOfPeople = 7;
        int step = 1;


        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numberOfPeople; i++) { //fill list
            list.add(i);
        }

        int position = 0;

        while (list.size() > 1) {
            position += step;

            if (list.size() - position <= step) {
                position = list.size() - position;
                System.out.print(list.get(position) + " ");
                list.remove(position);
            } else {
                System.out.print(list.get(position) + " ");
                list.remove(position);
            }
        }

        System.out.println(list.get(0)); //print last remaining element


    }
}
