package com.stepup.myprog.HomeworkNasledovanie;

public class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//class Point3D extends Point {
//    int z;
//    public Point3D(int x, int y,int z) {
//        super(x, y);
//        this.z = z;
//    }
//}

class Line implements Measurable {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double getLength() {
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}



class PolyLine implements Measurable {

    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i < points.length - 1; i++) {
            len1 = points[i].x - points[i+1].x;
            len2 = points[i].y - points[i+1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }
}

class ClosedPolyLine extends PolyLine{
    public ClosedPolyLine(Point... points) {
        super(points);
    }

    public double getLength() {
        int n = this.points.length;
        if (n == 1) return super.getLength();

        int dx = this.points[n - 1].x - this.points[0].x;
        int dy = this.points[n - 1].y - this.points[0].y;
        double lastSegment = Math.sqrt(dx * dx + dy * dy);

            return super.getLength() + lastSegment;
    }
}

class StringLen implements Measurable {
    private String str;

    public StringLen(String str) {
        this.str = str;
    }

    public double getLength() {
        return str.length();
    }
}

interface Measurable {
    double getLength();
}