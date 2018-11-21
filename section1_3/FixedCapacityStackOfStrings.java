package section1_3;
//ex1.3.1: Add a method isFull() to FixedCapacityStackOfStrings.

public class FixedCapacityStackOfStrings
{
    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }

    public boolean isFull() {
        if (a.length <= N) return true;
        return false;
    }
}