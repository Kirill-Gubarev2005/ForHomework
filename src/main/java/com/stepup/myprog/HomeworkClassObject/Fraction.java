package com.stepup.myprog.HomeworkClassObject;

import java.util.Arrays;
import java.util.Objects;

public class Fraction implements Cloneable {
    int num, denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return num == fraction.num && denum == fraction.denum;
    }

    public int hashCode() {
        return 7*(num + denum);
    }
    public Fraction clone() {
        return new Fraction(this.num, this.denum);
    }
    public String toString() {
        return num + "/" + denum;
    }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Point(this.x, this.y);
    }
}

class Line implements Cloneable{
    Point start,end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return start.equals(line.start) && end.equals(line.end);
    }

    public int hashCode() {
        return Objects.hash(start, end);
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Line(this.start, this.end);
    }
}

class PolyLine{

    Point[] points;

    public PolyLine(Point... points) {

        this.points = points;

    }

    public double length(){

        double sum=0,len1,len2;

        for(int i=0;i<points.length-1;i++){

            len1=points[i].x-points[i-1].x;

            len2=points[i].y-points[i-1].y;

            sum+=Math.sqrt(len1*len1+len2*len2);

        }

        return sum;

    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolyLine polyLine = (PolyLine) o;
        if (this.points.length != polyLine.points.length) return false;
        for (int i = 0; i < points.length; i++) {
            if (!(points[i] == polyLine.points[i])) return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(points);
    }
}