package com.stepup.myprog.HomeworkIncapsulation;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public String toString() {
        Employee chief = department.getChief();
        if (this == chief) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + chief.getName();
        }
    }
}
