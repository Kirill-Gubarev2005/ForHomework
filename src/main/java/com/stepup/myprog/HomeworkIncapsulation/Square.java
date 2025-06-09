package com.stepup.myprog.HomeworkIncapsulation;

public class Square {
    private int x;
    private int y;
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        setX(x);
        setY(y);
        setSideLength(sideLength);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной");
        }
        this.sideLength = sideLength;
    }

    public String toString() {
        return String.format("Квадрат в точке"+x+y+" со стороной"+ sideLength);
    }
}
