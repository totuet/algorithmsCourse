package section1_3;

/*
Write a class RandomQueue that implements this API. Hint : Use an array representation
(with resizing). To remove an item, swap one at a random position (indexed 0 through
N-1) with the one at the last position (index N-1). Then delete and return the last object,
as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each)
using RandomQueue<Card>.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomQueue<T> implements Iterable<T> {

    T[] array = (T[]) new Object[52];
    private int N;

    public boolean isEmpty() {return N == 0;}

    public int size() { return N;}

    public void enqueue(T item) {
        if ((N == 0)) array[0] = item;
        else array[N] = item;
        N++;
    }

    //remove and return a random item  (sample without replacement)
    public T dequeue() {
        Random rand = new Random();
        int n = rand.nextInt(N);
        array = Arrays.copyOf(array, N);
        T temp = array[n];
        array[n] = array[N-1];
        array[N-1] = null;
        N--;
        return temp;
    }


    //return a random item, but do not remove (sample with replacement)
    public T sample() {
        Random rand = new Random();
        int n = rand.nextInt(N);

        T temp = array[n];
        array[n] = array[N];
        array[N] = temp;

        return temp;
    }

    /*
    1.3.36 Random iterator. Write an iterator for RandomQueue<Item> from the previous
    exercise that returns the items in random order.
     */

    public Iterator<T> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<T> {


        public boolean hasNext() {return N > 0;}

        public T next() {
            return dequeue();
        }

    }


    public static void main(String[] args) {
        RandomQueue<Integer> rq = new RandomQueue<>();
        for (int i = 1; i <= 52; i++) {
            rq.enqueue(i);
        }
//        for (int i = 0; i < 4 ; i++) {
//            System.out.printf("Hand %d: " , i+1);
//            for (int j = 0; j < 13; j++) {
//                System.out.print(rq.dequeue() + ", ");
//            }
//            System.out.println();
//        }
        rq.forEach(System.out::println);
    }
}
