package com.stepup.myprog;

public class Homework {
    public static void main(String[] args) {
        System.out.println("Сложение чисел 5,11,123,14,1. Итог:"+lastNumSum(1,lastNumSum(14,lastNumSum(123,lastNumSum(5,11)))));
//        int a = 3;
//        int b = 15;
//        int c = 3;
//        System.out.println(isEqual(a,b,c));
//        int a = 3;
//        int b = 6;
//        System.out.println(isDivisor(a,b));
//        int a = 6;
//        int b = 5;
//        int num = 6;
//        System.out.println(isInRange(a,b,num));
//        char x = 'W';
//        System.out.println(isUpperCase(x));
//        int x = 34;
//        System.out.println(is2Digits(x));
//        double x = 3.5877654;
//        System.out.format("%.3f",fraction(x));
//        int x = 562398;
//        System.out.println(sumLastNums(x));
//        char x = '5';
//        System.out.println(charToNum(x));
//        int x = 3;
//        System.out.println(isPositive(x));
    }
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
//    public static boolean isEqual (int a, int b, int c){
//        return a == b && a== c;
//    }
//    public static boolean isDivisor (int a, int b){
//        return a%b == 0 | b%a ==0;
//    }
//    public static boolean isInRange(int a, int b, int num){
//        if(a>b) return  num >= b && num <= a;
//        if(a<b) return  num >= a && num <= b;
//        if (a==b) return num == a;
//        return true;
//    }
//    public static boolean isUpperCase(char x){
//        return x > 'A' && x < 'Z';
//    }
//    public static boolean is2Digits(int x){
//        if(x-(x%100)>0 | x-(x%100) < 0) return false;
//        else return true;
//    }
//    public static double fraction(double x) {
//        int res = (int) x;
//        x = x - res;
//        return x;
//    }
//    public static int sumLastNums(int x){
//        x= x%100;
//        int y = x%10;
//        int z= x/10;
//        int res = y+z;
//                return res;
//    }
//    public static int charToNum(char x){
//        int i = x - '0';
//        return i;
//    }
//    public static boolean isPositive(int x){
//        if(x>=0) return true;
//        else return false;
//    }



}
