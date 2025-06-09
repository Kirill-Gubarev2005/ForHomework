package com.stepup.myprog.HomeworkOOP;


public class Line {
    Point start,end;

    public Line(Point start,Point end){
        this.start = start;
        this.end = end;
    }

    public String toString(){
        return "Линия от"+start+"до"+end;
    }

    public double getLength(Point start, Point end){
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
