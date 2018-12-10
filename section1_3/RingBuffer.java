package section1_3;
/*
1.3.39 Ring buffer.
A ring buffer, or circular queue, is a FIFO data structure of a fixed size N.
It is useful for transferring data between asynchronous processes or for storing
log files.
When the buffer is empty, the consumer waits until data is deposited; when the
buffer is full, the producer waits to deposit data.

Develop an API for a RingBuffer and an implementation
that uses an array representation (with circular wrap-around).
 */

import java.nio.Buffer;
import java.util.Random;

public class RingBuffer<T> {
    private final int SIZE = 10;

    private T[] ringBuffer;
    private int size;
    private int head;
    private int tail;




    public RingBuffer() {
        ringBuffer = (T[]) new Object[SIZE];
    }

    public boolean isEmpty() {return size==0;}

    public boolean isFull() {return size == SIZE;}

    public int getSize() {return SIZE - size;}

    public int getMaxSize() {return SIZE;}

    public T consume() {
        T item = ringBuffer[tail];
        size--;
        if (!isEmpty()) {
            incrementTail();
        } else {
            System.out.println("No elements in buffer");
        }
        return item;
    }

    public void produce(T item) {
        try {
            if (!isFull()) {
                ringBuffer[head] = item;
                incrementHead();
                size++;
            } else {
                throw new BufferFullException("Buffer is full, please wait");
            }
        } catch (BufferFullException bfe) {
            System.out.println(bfe.getMessage());
        }
    }

    private void incrementHead() {
        if (head == SIZE - 1) head = 0;
        else head++;
    }

    private void incrementTail() {
        if (tail == SIZE - 1) tail = 0;
        else tail++;
    }

    private void printBuffer() {
        System.out.print("[ ");
        for (int i = 0; i < SIZE-1; i++) {
            System.out.print(ringBuffer[i] + " | ");
        }

        System.out.print(ringBuffer[SIZE-1] + " ]");

    }

    public static void main(String[] args) {

        //tried to simulate asynchronous writing and reading to the ringbuffer via a random int generator
        //if buffer is full

        RingBuffer<Integer> ringBuffer = new RingBuffer<>();
        doubleLinkedList<Integer> queue = new doubleLinkedList<>();
        Queue<Integer> queue2 = new Queue<>();
        Random rand = new Random();
        Integer temp;

        for (int i = 0; i < 30; i++) {
            queue.addHead(i);
        }
        int count = 1;
        while (!queue.isEmpty() || !ringBuffer.isEmpty()) {

            if (rand.nextInt(10) > 3 ) {
                System.out.print(count++ + ": ");
                ringBuffer.printBuffer();

                temp = queue.removeTail();
                if (!ringBuffer.isFull()) ringBuffer.produce(temp);
                else {
                    queue.addTail(temp);
                    System.out.print("*");
                }
                //System.out.println("Produced " + temp.toString());
                System.out.println();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            } else {
                System.out.print(count++ + ": ");
                ringBuffer.printBuffer();
                System.out.println();
                temp = ringBuffer.consume();
                queue2.enqueue(temp);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        }
    }

}
