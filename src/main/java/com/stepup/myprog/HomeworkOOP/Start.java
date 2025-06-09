package com.stepup.myprog.HomeworkOOP;

public class Start {
    public static void main(String[] args) {
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");


        A.addPath(B, 5);
        A.addPath(F, 1);
        A.addPath(D, 6);

        B.addPath(C, 3);
        B.addPath(A, 5);

        C.addPath(D, 4);
        C.addPath(B, 3);

        D.addPath(A, 6);
        D.addPath(E, 2);
        D.addPath(C, 4);

        E.addPath(F, 2);

        F.addPath(E, 2);

        System.out.println(B.travelBy(1));
        System.out.println(B.travelBy(2));
        System.out.println(B.travelBy(3));

    }
}

