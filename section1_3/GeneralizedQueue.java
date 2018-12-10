package section1_3;

//GeneralizedQueue array implementation

public class GeneralizedQueue<T> {
    private T[] array;
    private int size;

    public GeneralizedQueue(int initSize) {
        array = (T[]) new Object[initSize];
    }

    public boolean isEmpty() {return size == 0;}

    public void insert(T item) {
        try {
            array[size++] = item;
        } catch (ArrayIndexOutOfBoundsException aobe) {
            System.out.println("Full");
        }
    }

    private T get(int index) {
        return array[index-1];
    }

    public T delete(int k) {
        int index = (size - k);
        T item = array[index];
        array[index] = null;
        refactor(index);
        size--;
        return item;
    }

    private void refactor(int pos) {

    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> test = new GeneralizedQueue<>(10);
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);

        for (int i = 1; i <= 5; i++) {
            System.out.print(test.get(i) + " ");
        }

        test.delete(1);
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.print(test.get(i) + " ");
        }
    }
}
