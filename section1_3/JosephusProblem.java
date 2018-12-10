package section1_3;

public class JosephusProblem {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        int numberOfPeople = 7;
        int step = 2;

        for (int i = 0; i < numberOfPeople; i++) {
            queue.enqueue(i);
        }

        while (numberOfPeople-- != 0) {
            for (int i = 1; i < step; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");

        }

    }
}
