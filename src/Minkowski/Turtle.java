package Minkowski;

import StdDrawLib.StdDraw;

public class Turtle{
    private double x, y;
    private double angle;

    public Turtle(double x0, double y0, double a0){
        x = x0;
        y = y0;
        angle = a0;
    }

    public void turnLeft(double delta){
        angle += delta;
    }

    public void goForward(double step){
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    public void setXscale(double min, double max){
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max){
        StdDraw.setYscale(min, max);
    }
}
