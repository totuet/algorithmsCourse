package section1_3;
/*
Write a class RandomBag that implements this API. Note that this API is the same as for
Bag, except for the adjective random, which indicates that the iteration should provide
the items in random order (all N ! permutations equally likely, for each iterator). Hint :
Put the items in an array and randomize their order in the iterator’s constructor.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomBag<T> implements Iterable<T> {
    private T[] array = (T[])new Object[10];
    private int N;

    Random rand = new Random();




    public boolean isEmpty() {return N == 0;}

    public int size() {return N;}

    public void add(T item) {
        if (array[array.length * 3 / 4] != null) enlargeArray();
        if (N > 10 && array[array.length / 5] == null) shrinkArray();
        array[N] = item;
        N++;
    }

    private void enlargeArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void randomizeArray() {
        if (N == 0) return;
        T[] newArray = Arrays.copyOf(array,N);
        int g = newArray.length;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < newArray.length ; i++) { //randomize array
                int n = rand.nextInt(N);
                T temp = newArray[i];
                newArray[i] = newArray[n];
                newArray[n] = temp;
            }
        }

        array = newArray;



    }

    private void shrinkArray(){
        T[] newArray = (T[]) new Object[N/2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            array = newArray;
        }
    }

    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {

        private int counter = 1;

        public RandomBagIterator() {
            randomizeArray();
        }

        public boolean hasNext() {
            try {
                return array[counter - 1] != null;
            } catch (IndexOutOfBoundsException iobe) {
                return false;
            }
        }

        public T next() {
            return array[counter++ -1];

        }



    }

    public static void main(String[] args) {
        RandomBag<Integer> bag = new RandomBag<>();
        for (int i = 0; i < 50; i++) {
            bag.add(i);
        }
        Iterator<Integer> iterator = bag.iterator();

        for (int i = 0; i < bag.size(); i++) {
            System.out.printf("%d: %d %n", i+1, iterator.next());
        }

        bag.forEach(System.out::println);

    }

}
