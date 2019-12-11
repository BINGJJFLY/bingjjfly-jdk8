package com.wjz.jdk.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void empty() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }

    @Test
    public void equals() {
        Optional<Object> empty = Optional.empty();
        boolean equals = empty.equals("hello");
        System.out.println(equals);
    }

    @Test
    public void filter() {

    }
}
