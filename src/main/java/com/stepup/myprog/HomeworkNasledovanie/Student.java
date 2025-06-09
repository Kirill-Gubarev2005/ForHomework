package com.stepup.myprog.HomeworkNasledovanie;

import java.util.ArrayList;
import java.util.List;

public final class Student {
    private List<Integer> grades = new ArrayList<>();
    private String name;
    private GradeChecker checker;

    public interface GradeChecker {
        boolean isValid(int grade);
    }

    public Student(String name, GradeChecker checker) {
        this.name = name;
        this.checker = checker;
    }

    public void addGrade(int grade) {
        if (checker.isValid(grade)) {
            grades.add(grade);
        }
    }

    public String toString() {
        return "Student{grades=" + grades + ", name=" + name + '}';
    }
}
