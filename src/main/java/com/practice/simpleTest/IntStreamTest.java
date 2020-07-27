package com.practice.simpleTest;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(i -> System.out.println(i + ""));
    }
}
