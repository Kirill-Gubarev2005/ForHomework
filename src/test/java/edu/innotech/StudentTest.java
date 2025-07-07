package edu.innotech;

import com.stepup.myprog.edu.innoteh.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private StudentRepositoryMock studentRepoMock;

    @BeforeEach
    void setUp() {
        studentRepoMock = new StudentRepositoryMock();
        student = new Student("Кирилл", studentRepoMock);
    }

    @Test
    @DisplayName("Добавление корректных оценок")
    void shouldSaveValidGrades() {
        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);

        assertEquals(3, student.getGrades().size());
        assertTrue(student.getGrades().contains(3));
        assertTrue(student.getGrades().contains(4));
        assertTrue(student.getGrades().contains(5));
    }

    @Test
    @DisplayName("Добавление некорректных оценок")
    void shouldThrowExceptionForInvalidGrades() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(1));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(6));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(0));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(7));

        assertTrue(student.getGrades().isEmpty());
    }

    @Test
    @DisplayName("Расчёт рейтинга")
    void shouldCalculateRatingCorrectly() {
        student.addGrade(3);
        student.addGrade(4);
        assertEquals(50, student.raiting());

        student.addGrade(5);
        assertEquals(70, student.raiting());

        student.addGrade(5);
        student.addGrade(5);
        assertEquals(90, student.raiting());
    }

    @Test
    @DisplayName("Тест на метод getGrades()")
    void shouldReturnCopyOfGradesList() {
        student.addGrade(3);
        List<Integer> grades = student.getGrades();
        grades.add(4);

        assertEquals(1, student.getGrades().size());
        assertTrue(student.getGrades().contains(3));
        assertFalse(student.getGrades().contains(4));
    }

    @Test
    @DisplayName("Тест на getter и setter для name")
    void nameGetterAndSetterShouldWorkCorrectly() {
        assertEquals("Кирилл", student.getName());
        student.setName("Саша");
        assertEquals("Саша", student.getName());
    }

    @Test
    @DisplayName("Тест конструктора")
    void shouldInitializeFieldsCorrectly() {
        assertEquals("Кирилл", student.getName());
        assertTrue(student.getGrades().isEmpty());
    }
}