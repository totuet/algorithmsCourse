package section1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
Write an Interval2D client that takes command-line arguments N, min, and max
and generates N random 2D intervals whose width and height are uniformly distributed
between min and max in the unit square. Draw them on StdDraw and print the number
of pairs of intervals that intersect and the number of intervals that are contained in one
another.
 */

//Deze uitwerking is enorm bloated met de extra klasse, wilde daar iets anders mee proberen (contains testen)
public class ex1_1_3 {
    public static void main(String[] args) {
        int N = 10;
        double min = 0;
        double max = 1;
        int numberOfIntersects = 0;
        int numberOfContains = 0;
//        int N = Integer.parseInt(args[0]);
//        double min = Double.parseDouble(args[1]);
//        double max = Double.parseDouble(args[2]);
        Interval2D[] intervalArr = new Interval2D[N];

        for (int i = 0 ; i < N ; i++) {
           CreateRandomInterval2D cri = new CreateRandomInterval2D(min, max);
           intervalArr[i] = cri.getInterval2d();
           intervalArr[i].draw();

        }
        for (int i = 0 ; i < N ; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                if (intervalArr[i].intersects(intervalArr[j])) {
                    numberOfIntersects++;
                }

                }
            }
        System.out.println(numberOfIntersects);
    }
}

class CreateRandomInterval2D {
    public double x1;
    public double x2;
    public double x3;
    public double x4;


    public Interval2D interval2d;

    public CreateRandomInterval2D (double min, double max){
        double rand1 = StdRandom.uniform(min,max);
        double rand2 = StdRandom.uniform(min,max);
        double rand3 = StdRandom.uniform(min,max);
        double rand4 = StdRandom.uniform(min,max);
        this.x1 = rand1;
        this.x2 = rand2;
        this.x3 = rand3;
        this.x4 = rand4;
        if (rand1 > rand2) {
            x1 = rand2;
            x2 = rand1;
        }
        if (rand3 > rand4) {
            x3 = rand4;
            x4 = rand3;
        }


        interval2d = new Interval2D(
                new Interval1D(x1, x2),
                new Interval1D(x3, x4));

    }
    public Interval2D getInterval2d() {
        return interval2d;
    }



}
