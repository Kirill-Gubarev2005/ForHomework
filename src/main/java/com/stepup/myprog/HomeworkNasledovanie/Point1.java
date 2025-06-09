package com.stepup.myprog.HomeworkNasledovanie;

public class Point1 {
    private Integer x;
    private Integer y;
    private Integer z;

    public Point1(int x) {
        this.x = x;
    }

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point1(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getCoordinates() {
        String result = "{" + x;
        if (y != null) {
            result += ", " + y;
        }
        if (z != null) {
            result += ", " + z;
        }
        result += "}";
        return result;
    }
}
interface Colorable {
    String getColor();
}

interface Timed {
    String getTime();
}

class ColorPoint extends Point1 implements Colorable {
    private String color;

    public ColorPoint(int x, String color) {
        super(x);
        this.color = color;
    }

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint(int x, int y, int z, String color) {
        super(x, y, z);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
class TimedPoint extends Point1 implements Timed {
    private String time;

    public TimedPoint(int x, String time) {
        super(x);
        this.time = time;
    }

    public TimedPoint(int x, int y, String time) {
        super(x, y);
        this.time = time;
    }

    public TimedPoint(int x, int y, int z, String time) {
        super(x, y, z);
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}

class ColorTimedPoint extends Point1 implements Colorable, Timed {
    private String color;
    private String time;

    public ColorTimedPoint(int x, String color, String time) {
        super(x);
        this.color = color;
        this.time = time;
    }

    public ColorTimedPoint(int x, int y, String color, String time) {
        super(x, y);
        this.color = color;
        this.time = time;
    }

    public ColorTimedPoint(int x, int y, int z, String color, String time) {
        super(x, y, z);
        this.color = color;
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public String getTime() {
        return time;
    }
}
