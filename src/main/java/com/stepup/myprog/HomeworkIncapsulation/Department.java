package com.stepup.myprog.HomeworkIncapsulation;


public class Department {
    private String name;
    private Employee chief;

    public Department(String name) {
        this.name = name;
        this.chief = null;
    }

    public String getName() {
        return name;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        if (chief.getDepartment() != this) {
            throw new IllegalArgumentException("Начальник должен работать в отделе " + name);
        }
        this.chief = chief;
    }
}