package com.stepup.myprog;

import java.util.Arrays;

public class HomeWorkArr {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,-4,5,6,-7,8,5};
        int[] arr2 = {11,12,13,};
        int pos = 3;
        System.out.println(Arrays.toString(add(arr1,arr2,pos)));
    }
    public static int[] add(int[] arr, int[] ins, int pos){
        int[] resarr = new int[arr.length+ ins.length];
        for (int i=0; i<pos; i++){
            resarr[i] = arr[i];
        }
        for (int i=0; i<= ins.length-1; i++) {
            resarr[i+pos] = ins[i];
        }

        for (int i = pos; i <= arr.length-1; i++) {
            resarr[i+ins.length] = arr[i];
        }
        return resarr;
    }
//    public static int[] add(int[] arr, int x, int pos){
//        int[] resarr = new int[arr.length+1];
//        for (int i=0; i<pos; i++){
//            resarr[i] = arr[i];
//        }
//        resarr[pos] = x;
//        for (int i = pos + 1; i <= arr.length; i++) {
//            resarr[i] = arr[i - 1];
//        }
//        return resarr;
//    }
//    public static int[] deleteNegative(int[] arr){
//        int count = 0;
//        for (int i=0;i<= arr.length-1;i++){
//            if (arr[i]<0){
//                count++;
//            }
//        }
//        int[] resarr = new int[arr.length - count];
//        int ind = 0;
//        for (int i=0; i<= arr.length-1; i++){
//            if (arr[i]>=0){
//                resarr[ind] = arr[i];
//                ind++;
//            }
//        }
//        return resarr;
//    }
//    public static int[] findAll(int[] arr, int x) {
//        int count = 0;
//        for (int i=0; i<= arr.length-1; i++) {
//            if (arr[i] == x) {
//                count++;
//            }
//        }
//        int[] resar = new int[count];
//        int ind = 0;
//        for (int i = 0; i <= arr.length-1; i++) {
//            if (arr[i] == x) {
//                resar[ind] = i;
//                ind++;
//            }
//        }
//        return resar;
//    }
//    public static int[] concat(int[] arr1, int[] arr2){
//        int[] resarr = new int[arr1.length + arr2.length];
//        for (int i = 0; i < arr1.length; i++) {
//            resarr[i] = arr1[i];
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            resarr[arr1.length + i] = arr2[i];
//        }
//        return resarr;
//    }
//    public static int[] reverseBack(int[] arr){
//        int[] arr1 = new int[arr.length];
//        for (int i=0; i<= arr.length-1; i++){
//            arr1[i] = arr[arr.length-1-i];
//        }
//        arr = arr1;
//        return arr;
//    }
//    public static void reverse(int[] arr){
//        int[] arr1 = new int[arr.length];
//        for (int i=0; i<= arr.length-1; i++){
//            arr1[i] = arr[arr.length-1-i];
//        }
//        arr = arr1;
//        System.out.println(Arrays.toString(arr));
//    }
//    public static boolean palindrom(int[] arr) {
//        for (int i = 0; i < arr.length / 2; i++) {
//            if (arr[i] != arr[arr.length - 1 - i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static int countPositive(int[] arr){
//        int counter = 0;
//        for (int i=0; i<= arr.length-1;i++){
//            if(arr[i]>0){counter++;}
//        }
//        return counter;
//    }
//    public static int abs(int x) {
//        if (x < 0){
//            x = x*(-1);
//            return x;
//        }
//        return x;
//    }
//    public static int maxAbs(int[] arr){
//        int max = abs(arr[0]);
//        int truemax = arr[0];
//        for (int i=0; i<= arr.length-1;i++){
//            if (abs(arr[i])>max){max = abs(arr[i]); truemax = arr[i];}
//        }
//        return truemax;
//    }
//    public static int findLast(int[] arr, int x){
//        for (int i =arr.length-1; i>=0;i--){
//            if(arr[i] == x){
//                return i;
//            }
//        }
//        return -1;
//    }
//    public static int findFirst(int[] arr, int x){
//        for (int i =0; i< arr.length-1;i++){
//            if(arr[i] == x){
//                return i;
//            }
//        }
//        return -1;
//    }
}