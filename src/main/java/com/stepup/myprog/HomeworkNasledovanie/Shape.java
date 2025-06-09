package com.stepup.myprog.HomeworkNasledovanie;

interface Shape {
    double getArea();
}

class  Circle implements Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public  double getArea() {
        return Math.PI * radius * radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}

class Square implements Shape {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double getSideLength() {
        return sideLength;
    }
}

class Rectangle implements Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
