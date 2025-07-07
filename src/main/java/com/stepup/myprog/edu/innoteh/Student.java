package com.stepup.myprog.edu.innoteh;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Student {
    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();
    private final StudentRepo studentRepo;

    public Student(String name, StudentRepo studentRepo) {
        this.name = name;
        this.studentRepo = studentRepo;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @SneakyThrows
    public void addGrade(int grade) {
        if (!studentRepo.checkGrade(grade)) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int raiting() {
        int sum = grades.stream().mapToInt(x -> x).sum();
        return studentRepo.getRaintingForGradeSum(sum);
    }
}