package com.stepup.myprog.HomeworkStreams;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Hello", "world", "from", "Java");
        System.out.println(getStringFromStream(stream)); // Выведет: "Hello world from Java"
    }
    public static String getStringFromStream(Stream<String> stringStream) {
        String res = stringStream.collect(Collectors.joining(" "));
        return res;
    }
    public static void printList(ArrayList<Integer> list) {
        list.forEach(i -> System.out.println(i));
    }
}


