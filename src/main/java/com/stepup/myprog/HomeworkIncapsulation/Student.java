package com.stepup.myprog.HomeworkIncapsulation;

import java.util.Arrays;

public class Student {
    private final String name;
    private int[] grades;

    public Student(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        this.grades = new int[0];
    }

    public Student(String name, int[] grades) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        this.grades = new int[0];
        for (int grade : grades) {
            addGrade(grade);
        }
    }

    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        }
        int[] newG = new int[grades.length + 1];
        for (int i = 0; i<=grades.length-1; i++){
            newG[i] = grades[i];
        }
        newG[newG.length - 1] = grade;
        this.grades = newG;
    }


    public int[] getGrades() {
        return grades;
    }

    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
