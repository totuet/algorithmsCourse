package section1_2;

import edu.princeton.cs.algs4.*;

import java.awt.*;

/*
Write a Point2D client that takes an integer value N from the command line,
generates N random points in the unit square, and computes the distance separating
the closest pair of points.
 */

public class ex1_2_1 {
    public static void main(String[] args) {
        int N = 15;
        Point2D[] pointArr = new Point2D[N];
        Point2D[] shortestPoints = new Point2D[2];
        StdDraw.setPenRadius(0.005);

        for (int i = 0; i < N ; i++) {
            pointArr[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());

        }
        shortestPoints[0] = pointArr[0];
        shortestPoints[1] = pointArr[1];



        for (int i = 0; i < pointArr.length ; i++) {
            for (int j = i + 1; j < pointArr.length; j++) {
                if (pointArr[i].distanceTo(pointArr[j]) < shortestPoints[0].distanceTo(shortestPoints[1])) {
                    shortestPoints[0] = pointArr[i];
                    shortestPoints[1] = pointArr[j];
                }
            }
        }
        for (Point2D point : pointArr) {
            StdDraw.point(point.x(),point.y());

        }
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(shortestPoints[0].x(),shortestPoints[0].y(),shortestPoints[1].x(),shortestPoints[1].y());
    }
}
