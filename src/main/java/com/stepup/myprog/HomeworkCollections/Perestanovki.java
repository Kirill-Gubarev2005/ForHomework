package com.stepup.myprog.HomeworkCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perestanovki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите четное число N: ");
        int N = scanner.nextInt();

        if (N % 2 != 0) {
            System.out.println("N должно быть четным числом");
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        System.out.println("Исходный список: " + list);

        for (int i = 0; i < N; i += 2) {
            int temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }

        System.out.println("Список после замены: " + list);
    }
}