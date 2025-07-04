package com.stepup.myprog.HomeworkIsklucheniya;
public class Sum {
    public static void main(String[] args) {
        double sum = 0;
        for (String arg : args) {
            if (isNumeric(arg)) {
                sum += Double.parseDouble(arg);
            }
        }
        System.out.println(sum);

    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Double.parseDouble(str);
        return true;
    }
}
