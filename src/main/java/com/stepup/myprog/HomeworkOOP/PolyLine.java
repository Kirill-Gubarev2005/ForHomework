package com.stepup.myprog.HomeworkOOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public String toString() {
        String res = "Линия [";
        for (int i = 0; i < points.size(); i++) {
            res = res + points.get(i).toString();
            if (i < points.size() - 1) {
                res = res + ",";
            }
        }
        res = res + "]";
        return res;
    }

    public Line[] getLines() {
        Line[] lines = new Line[points.size() - 1];
        for (int i = 0; i < points.size() - 1; i++) {
            lines[i] = new Line(points.get(i), points.get(i + 1));
        }
        return lines;
    }

    public double getLength() {
        double length = 0;
        Line[] lines = getLines();
        for (Line line : lines) {
            length += line.getLength(line.start,line.end);
        }
        return length;
    }

    public List<Point> getPoints() {
        return points;
    }
}

