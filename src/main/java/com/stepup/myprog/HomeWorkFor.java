package com.stepup.myprog;

import java.util.Scanner;

public class HomeWorkFor {
    public static void main(String[] args) {
        guessGame();
    }
    public static void guessGame() {
        int randomNum = 3;
        int counter = 0;
        boolean cheker = false;
        while (cheker != true) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println("What number am I thinking (0 to 9)? :");
            int x = sc.nextInt();
            if (x != randomNum) {
                System.out.println("No, try again");
                counter++;
            } else {
                System.out.println("Yes, it`s " + randomNum);
                cheker = true;
                System.out.println("Number of guesses:"+counter);
            }
        }
    }
//    public static void rightTriangle(int x){
//        for (int i=0; i<x; i++){
//            for (int j = 0; j < x - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j=0; j<=i; j++){
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//
//    }
//    public static void leftTriangle(int x){
//        for (int i=0; i<x; i++){
//            for (int j=0; j<=i; j++){
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//    }
//    public static void square(int x){
//        for (int i=0; i< x; i++){
//            for (int j=0; j < x; j++){
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//
//    }
//    public static boolean equalNum(int x) {
//        int ex = x % 10;
//        x /= 10;
//        while (x != 0) {
//            if (x%10 != ex) {
//                return false;
//            }
//            x /= 10;
//        }
//        return true;
//    }
//    public static int numLen(long x){
//        int count = 0;
//        do {
//            x/= 10;
//            count++;
//        } while (x!=0);
//        return count;
//    }
//    public static int pow(int x, int y){
//        int res = 1;
//        for (int i = 1; i<=y; i++){
//            res *= x;
//        }
//        return res;
//    }
//    public static String chet(int x){
//        String res = "";
//        for (int i=0; i<=x; i+=2){
//            res += i+" ";
//        }
//        return res;
//    }

//    public static String reverseListNums(int x){
//        String res = "";
//        for (int i = x; i>=0; i--){
//            res += i+" ";
//        }
//        return res;
//    }
//    public static String listNums(int x){
//        String res = "";
//        for (int i = 0; i<=x; i++){
//            res += i+" ";
//        }
//        return res;
//    }
}
