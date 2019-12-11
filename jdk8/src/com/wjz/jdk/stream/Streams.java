package com.wjz.jdk.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class Streams {

    public enum Status {
        OPEN, CLOSED;
    }

    public static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }
}
