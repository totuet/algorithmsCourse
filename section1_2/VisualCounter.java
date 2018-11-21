package section1_2;

import edu.princeton.cs.algs4.*;

/*
Develop a class VisualCounter that allows both increment and decrement
operations. Take two arguments N and max in the constructor, where N specifies the
maximum number of operations and max specifies the maximum absolute value for
the counter. As a side effect, create a plot showing the value of the counter each time its
tally changes.
 */

public class VisualCounter {
    private int maxNumOfOps;
    private int maxAbsValue;
    private int counter;
    private int secondcounter = 0;



    public VisualCounter(int N, int max) {
        this.maxNumOfOps = N;
        this.maxAbsValue = max;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(-max,max);
        StdDraw.setPenRadius(0.005);
    }

    public void increment() {
        if (Math.abs(counter) < maxAbsValue){
         this.counter++;
         this.secondcounter++;
         StdDraw.point(this.secondcounter,this.counter);
        }
    }

    public void decrement() {
        if (Math.abs(counter) < maxAbsValue) {
            this.counter--;
            this.secondcounter++;
            StdDraw.point(this.secondcounter,this.counter);

        }
    }

    public int getCounter(){
        return this.counter;
    }

    public static void main(String[] args) {
        VisualCounter vscntr = new VisualCounter(10, 10);
        vscntr.increment();
        vscntr.increment();
        vscntr.increment();
        vscntr.increment();
        vscntr.decrement();
        vscntr.decrement();
        vscntr.decrement();
        vscntr.decrement();
        vscntr.increment();
        vscntr.increment();

    }

}
