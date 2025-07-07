package edu.innotech;

import com.stepup.myprog.edu.innoteh.Student;
import com.stepup.myprog.edu.innoteh.StudentRepo;

public class StudentRepositoryMock implements StudentRepo {
    public boolean checkGrade(int grade) {
        return grade >= 2 && grade <= 5;
    }
    public int getRaintingForGradeSum(int sum) {
        if (sum <= 10) return 50;
        if (sum <= 20) return 70;
        return 90;
    }
    public long count(){return 0;}
    public void delete(Student entity){}
    public void deleteAll(Iterable<Student> entities){}
    public Iterable<Student> findAll(){return null;}
    public Student save(Student entity){return null;}
    public Iterable<Student> saveAll(Iterable<Student> entities){return null;}
}