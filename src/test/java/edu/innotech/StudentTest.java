package edu.innotech;

import com.stepup.myprog.edu.innoteh.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Кирилл");
    }

    @Test
    @DisplayName("Тест на метод getName")
    void testGetName() {
        assertEquals("Кирилл", student.getName());
    }

    @Test
    @DisplayName("Тест на метод setName")
    void testSetName() {
        student.setName("Саша");
        assertEquals("Саша", student.getName());
    }

    @Test
    @DisplayName("Тест на метод getGrades")
    void testAddValidGrade() {
        student.addGrade(4);
        student.addGrade(5);
        assertEquals(Arrays.asList(4, 5), student.getGrades());
    }

    @Test
    @DisplayName("Тест на метод addGrade")
    void testAddInvalidGrade() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(0));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(1));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(6));
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(7));

    }

    @Test
    @DisplayName("Тест на инкапсуляцию")
    void testGetGradesEncapsulation() {
        student.addGrade(3);
        student.addGrade(4);

        List<Integer> grades = student.getGrades();

        assertThrows(UnsupportedOperationException.class, () -> grades.add(5));
        assertThrows(UnsupportedOperationException.class, () -> grades.remove(0));
    }

    @Test
    @DisplayName("Тест на equals и hashCode")
    void testEqualsAndHashCode() {
        Student student1 = new Student("Кирилл");
        student1.addGrade(4);
        student1.addGrade(5);
        Student student2 = new Student("Кирилл");
        student2.addGrade(4);
        student2.addGrade(5);
        Student differentStudent = new Student("Кирилл1");
        differentStudent.addGrade(3);

        assertEquals(student1, student1);
        assertEquals(student1, student2);
        assertNotEquals(student1, differentStudent);
        assertNotEquals(student1, null);
        assertNotEquals(student1, new Object());

        assertEquals(student1.hashCode(), student2.hashCode());
        assertNotEquals(student1.hashCode(), differentStudent.hashCode());
    }
    @Test
    @DisplayName("Тест на toString")
    void testToString() {
        student.addGrade(4);
        student.addGrade(5);
        assertEquals("Student{name=Кирилл, marks=[4, 5]}", student.toString());
    }
}