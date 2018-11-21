package exercises01_01;

/*
exercise to check whether a random point is on a circle. If it is draw point in different color.
 */

import edu.princeton.cs.algs4.*;


import java.awt.*;

public class IsPointOnCircle {
    public static void main(String[] args) {
        int numberOfPoints = 10000;
        double radius = .3;

        StdDraw.setCanvasSize(900,900);
        //StdDraw.circle(.5,.5, radius);

        for (int i = 0; i < numberOfPoints; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D center = new Point2D(.5,.5);
            Point2D point = new Point2D(x,y);
            //if (Math.abs(point.distanceTo(center) - radius) < 0.001 ) {
            if (point.distanceTo(center) < radius) {
                StdDraw.setPenColor(Color.CYAN);
                StdDraw.setPenRadius(.009);
                point.draw();
            } else {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.setPenRadius(.004);
                point.draw();
            }

        }
    }
}
