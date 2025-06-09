package com.stepup.myprog.HomeworkIncapsulation;

public class Start {
    public static void main(String[] args) {
        Department sales = new Department("Продажи");

        Employee ivan = new Employee("Иван Иванов", sales);
        sales.setChief(ivan);  // Назначаем начальника отдела

        Employee petr = new Employee("Петр Петров", sales);

        System.out.println(ivan);  // Иван Иванов начальник отдела Продажи
        System.out.println(petr);  // Петр Петров работает в отделе Продажи, начальник которого Иван Иванов

        Department hr = new Department("Кадры");
        Employee maria = new Employee("Мария Сидорова", hr);

        try {
            sales.setChief(maria);  // Ошибка, Мария не работает в отделе Продажи
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}