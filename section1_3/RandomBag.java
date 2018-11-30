package section1_3;
/*
Write a class RandomBag that implements this API. Note that this API is the same as for
Bag, except for the adjective random, which indicates that the iteration should provide
the items in random order (all N ! permutations equally likely, for each iterator). Hint :
Put the items in an array and randomize their order in the iterator’s constructor.
 */

import java.util.Iterator;

public class RandomBag<T> implements Iterable<T> {
    private Node first;
    private int N;

    private class Node{
        Node next;
        T item;
    }

    public boolean isEmpty() {return first == null;}

    public int size() {return N;}

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        N++;
    }

    private T pop(){
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {

        public T[] createArray () {
            Object[] array = new Object[N];
            for (int i = 0; i < N; i++) {
                array[i] = pop();
            }
            return (T[]) array;
        }





    }

}
