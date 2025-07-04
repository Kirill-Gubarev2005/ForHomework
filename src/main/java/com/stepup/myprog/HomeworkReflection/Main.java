package com.stepup.myprog.HomeworkReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void clearObjectFields(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            if (!field.getType().isPrimitive()) {
                field.set(obj, null);
            }
        }
    }
    public static void main(String[] args) throws IllegalAccessException {
        // Тестируем на классе Cat
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        System.out.println("Before nullify: " + cat);
        clearObjectFields(cat);
        System.out.println("After nullify: " + cat);

        // Тестируем на классе Dog
        Dog dog = new Dog("Sharik", 5, new ArrayList<>(Arrays.asList("Bobik", "Tuzik")));
        System.out.println("\nBefore nullify: " + dog);
        clearObjectFields(dog);
        System.out.println("After nullify: " + dog);
    }
}

class Cat {
    private static String breed = "Persian"; // порода
    public String name;
    private int age;
    private List<String> friendsName = new ArrayList<>();

    public Cat(String name, int age, List<String> friendsName) {
        this.name = name;
        this.age = age;
        this.friendsName = friendsName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendsName=" + friendsName +
                '}';
    }
}

class Dog {
    private static String breed = "Labrador";
    public String name;
    private int age;
    private List<String> friendsName;

    public Dog(String name, int age, List<String> friendsName) {
        this.name = name;
        this.age = age;
        this.friendsName = friendsName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendsName=" + friendsName +
                '}';
    }
}

