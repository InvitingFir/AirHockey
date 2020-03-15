package com.roman.AirHockey.Util;

public class Vector {
    private double x;
    private double y;
    private double length;
    private double angle;

    public Vector(double startX, double startY, double finishX, double finishY){
        x = finishX - startX;
        y = finishY - startY;
        length = Math.sqrt(x*x + y*y);
        angle = (Math.atan2(y, x) + 2*Math.PI) % (2*Math.PI);
    }

    public static double angleBetweenVectors(Vector a, Vector b){
        double aa = Math.acos((a.getX()*b.getX() + a.getY()*b.getY()) / (a.getLength() * b.getLength()));
        return aa;
    }

    public double getX() {
        return x;
    }

    public double getY() { return y; }

    public double getLength() {
        return length;
    }

    public double getAngle() {
        return angle;
    }
}
