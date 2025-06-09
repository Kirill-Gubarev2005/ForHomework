package com.stepup.myprog.HomeworkNasledovanie;

import java.util.Random;


public class Bird {
    public void sing(){
        System.out.println("song");
    }

}
class Sparrow extends Bird {
    public void sing() {
        System.out.println("чырык");
    }
}
class Coocoo extends Bird {
    Random random = new Random();

    public void sing() {
        int num = random.nextInt(10) + 1;
        for (int i = 0; i < num; i++) {
            System.out.println("ку-ку");
        }
    }
}
class Parrot extends Bird {
    private final String text;
    Random random = new Random();

    public Parrot(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть пустым");
        }
        this.text = text;
    }
    public void sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}