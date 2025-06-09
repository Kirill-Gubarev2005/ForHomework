package com.stepup.myprog.HomeworkNasledovanie;

import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Circle circle1 = new Circle(new Point(0, 0), 3);
        Circle circle2 = new Circle(new Point(5, 5), 2.5);
        Square square1 = new Square(new Point(1, 1), 4);
        Square square2 = new Square(new Point(-2, -2), 5);

        List<Shape> shapes = Arrays.asList(circle1, circle2, square1, square2);

        ShapeAreaCalculator calculator = new ShapeAreaCalculator();
        double totalArea = calculator.sumAllAreas(shapes);
        System.out.println(totalArea);
    }
}

class ShapeAreaCalculator {
    public double sumAllAreas(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}