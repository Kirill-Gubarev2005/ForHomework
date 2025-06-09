package com.stepup.myprog;

import java.util.Scanner;

public class HomeWorkIF{
    public static void main(String[] args) {
        String x = new Scanner(System.in).nextLine();
        printDays(x);
    }
    public static void printDays(String x) {
        switch (x.toLowerCase()) {
            case "понедельник": System.out.print("понедельник ");
            case "вторник": System.out.print("вторник ");
            case "среда": System.out.print("среда ");
            case "четверг": System.out.print("четверг ");
            case "пятница": System.out.print("пятница ");
            case "суббота": System.out.print("суббота ");
            case "воскресенье": System.out.print("воскресенье");break;
            default: System.out.println("это не день недели");
        }
    }

//    public static String day(int x){
//        switch (x){
//            case 1: return "понедельник";
//            case 2: return "вторник";
//            case 3: return "среда";
//            case 4: return "четверг";
//            case 5: return "пятница";
//            case 6: return "суббота";
//            case 7: return "воскресенье";
//            default: return "Это не день недели";
//        }
//    }
//    public static String age(int x) {
//        if (x % 10 == 1 && x % 100 != 11) return x + " год";
//        if ((x % 10 >= 2 && x % 10 <= 4) && (x % 100 != 12 && x % 100 != 13 &&  x % 100 != 14)) return x + " года";
//        else return x + " лет";
//    }
//    public static boolean magic6(int x, int y){
//        if (x == 6| y == 6| x+y == 6| (x-y)*(x-y) == 36) return true;
//        return false;
//    }
//    public static boolean is35(int x){
//        if (x%15 == 0) return false;
//        if (x%3 == 0 | x%5 == 0) return true;
//        return false;
//    }
//    public static int sum2(int x, int y){
//        if(x+y>=10&&x+y<=19) return 20;
//        return x+y;
//    }
//    public static boolean sum3(int x, int y, int z){
//        if (x+y == z) return true;
//        if (x+z == y) return true;
//        if (z+y == x) return true;
//        return false;
//    }
//    public static int max3(int x, int y, int z){
//        int max = x;
//        if (y > max) max = y;
//        if (z > max) max = z;
//        return max;
//    }
//    public static String makeDecision(int x, int y){
//        if (x > y) return x + ">" + y;
//        if (x < y) return x + "<" + y;
//        else return x + "=" + y;
//    }
//    public static int max(int x, int y){
//        if (x>y) return x;
//        return y;
//    }
//    public static int safeDiv(int x, int y){
//        if (y == 0) return 0;
//        return x/y;
//    }
//    public static int abs(int x){
//        if (x < 0) return -x;
//        return x;
//    }
}
