package com.stepup.myprog.HomeworkIsklucheniya;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static int divide(String fileName) throws OperationAttemptException {
        File f = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(f);
            return sc.nextInt() / sc.nextInt();
        } catch (FileNotFoundException e) {
            throw new OperationAttemptException("File not found", e);
        } catch (InputMismatchException e) {
            throw new OperationAttemptException("Invalid input format", e);
        } catch (NoSuchElementException e) {
            throw new OperationAttemptException("Not enough numbers in file", e);
        } catch (ArithmeticException e) {
            throw new OperationAttemptException("Division by zero", e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            int result = divide("12, 12");
            System.out.println(result);
        } catch (OperationAttemptException e) {
            System.out.println(0);
        }
    }
}
