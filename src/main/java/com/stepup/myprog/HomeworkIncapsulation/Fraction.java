package com.stepup.myprog.HomeworkIncapsulation;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель не может быть меньше/равно 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction x) {
        int newNumerator = this.numerator * x.denominator + this.denominator * x.numerator;
        int newDenominator = this.denominator * x.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtraction(Fraction x) {
        int newNumerator = this.numerator * x.denominator - this.denominator * x.numerator;
        int newDenominator = this.denominator * x.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction sumWithNumber(int x) {
        return new Fraction(this.numerator + this.denominator * x, this.denominator);
    }

    public Fraction subtractionWithNumber(int x) {
        return new Fraction(this.numerator - this.denominator * x, this.denominator);
    }
}