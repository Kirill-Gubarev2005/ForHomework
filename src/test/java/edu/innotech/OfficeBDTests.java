package edu.innotech;

import com.stepup.myprog.edu.innoteh.DatabaseConnection;
import com.stepup.myprog.edu.innoteh.Department;
import com.stepup.myprog.edu.innoteh.Employee;
import com.stepup.myprog.edu.innoteh.Service;
import com.stepup.myprog.edu.innoteh.H2DatabaseConnection;
import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class OfficeBDTests {
    private static DatabaseConnection dbConnection;

    @BeforeAll
    static void setupAll() {
        dbConnection = new H2DatabaseConnection();
    }

    @BeforeEach
    void setUp(){
        Service.setDatabaseConnection(dbConnection);
        Service.createDB();
    }

    @AfterEach
    void close() throws SQLException {
        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement()) {
            stm.execute("DROP ALL OBJECTS");
        }
    }

    @Test
    @DisplayName("Добавление нового департамента")
    void testAddDepartment() throws SQLException {
        Department newDept = new Department(4, "Marketing");
        Service.addDepartment(newDept);

        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Department WHERE ID=4")) {
            assertTrue(rs.next());
            assertEquals(1, rs.getInt(1));
        }
    }

    @Test
    @DisplayName("Удаление департамента с каскадным удалением сотрудников")
    void testRemoveDepartment() throws SQLException {
        Department deptToRemove = new Department(1, "");
        Service.removeDepartment(deptToRemove);

        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Department WHERE ID=1")) {
            assertTrue(rs.next());
            assertEquals(0, rs.getInt(1));
        }

        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Employee WHERE DepartmentID=1")) {
            assertTrue(rs.next());
            assertEquals(0, rs.getInt(1));
        }
    }

    @Test
    @DisplayName("Добавление нового сотрудника")
    void testAddEmployee() throws SQLException {
        Employee newEmployee = new Employee(6, "John", 2);
        Service.addEmployee(newEmployee);

        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Employee WHERE ID=6")) {
            assertTrue(rs.next());
            assertEquals(1, rs.getInt(1));
        }
    }

    @Test
    @DisplayName("Удаление сотрудника по ID")
    void testRemoveEmployee() throws SQLException {
        Employee empToRemove = new Employee(1, "", 0);
        Service.removeEmployee(empToRemove);

        try (Connection con = dbConnection.getConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Employee WHERE ID=1")) {
            assertTrue(rs.next());
            assertEquals(0, rs.getInt(1));
        }
    }

    @Test
    @DisplayName("Проверка начального состояния базы данных")
    void testResetDB() throws SQLException {
        try (Connection con = dbConnection.getConnection();
             Statement stm1 = con.createStatement();
             ResultSet rs1 = stm1.executeQuery("SELECT COUNT(*) FROM Department");
             Statement stm2 = con.createStatement();
             ResultSet rs2 = stm2.executeQuery("SELECT COUNT(*) FROM Employee")) {

            assertTrue(rs1.next());
            assertEquals(3, rs1.getInt(1));

            assertTrue(rs2.next());
            assertEquals(5, rs2.getInt(1));
        }
    }
}