package exercises01_01;
import edu.princeton.cs.algs4.*;


/*
Random connections. Write a program that takes as command-line arguments
an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size
.05 on the circumference of a circle, and then, with probability p for each pair of points,
draws a gray line connecting them.
 */
public class ex1_1_31 {
    public static void main(String[] args) {

        double radius = .4;
        double alpha = 0;
        //int N = Integer.parseInt(args[0]);
        int N = 50;
        double p = .1;
        Point2D[] pointArr = new Point2D[N];

        StdDraw.setCanvasSize(800, 800);
        StdDraw.circle(0.5, 0.5 , radius);
        StdDraw.setPenRadius(.01);


        for (int i = 0; i < N ; i++) {
            double x =  .5 + radius * Math.cos(alpha);
            double y =  .5 + radius * Math.sin(alpha);
            StdDraw.point(x,y);
            alpha += 6.28 / N;
            pointArr[i] = new Point2D(x, y);

        }
        StdDraw.setPenRadius(.0001);
        for (int i = 0; i < pointArr.length ; i++) {
            for (int j = i + 1; j < pointArr.length; j++) {
                if (StdRandom.bernoulli(p)) {
                StdDraw.line(pointArr[i].x(), pointArr[i].y(), pointArr[j].x(),pointArr[j].y());
                }
            }
        }

    }
}
