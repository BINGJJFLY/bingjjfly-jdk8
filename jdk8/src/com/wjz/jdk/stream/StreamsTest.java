package com.wjz.jdk.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsTest {

    @Test
    public void sum() {
        final Collection<Streams.Task> tasks = Arrays.asList(
                new Streams.Task(Streams.Status.OPEN, 5),
                new Streams.Task(Streams.Status.OPEN, 13),
                new Streams.Task(Streams.Status.CLOSED, 8)
        );
        int sum = tasks.stream().filter(task -> task.getStatus() == Streams.Status.OPEN)
                .mapToInt(Streams.Task::getPoints)
                .sum();
        System.out.println("OPEN sum is：" + sum);

        final int totalPoints = tasks.stream().parallel().map(Streams.Task::getPoints).reduce(0, Integer::sum);
        System.out.println("parallel sum is：" + totalPoints);

        final Map<Streams.Status, List<Streams.Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Streams.Task::getStatus));
        System.out.println(map);

        final List<String> result = tasks.stream()
                .mapToInt(Streams.Task::getPoints)
                .asLongStream()
                .mapToDouble(points -> new BigDecimal(points).divide(new BigDecimal(totalPoints), 2, BigDecimal.ROUND_HALF_UP).doubleValue())
                .boxed()
                .mapToLong(weight -> (long) (weight * 100))
                .mapToObj(percentage -> percentage + "%")
                .collect(Collectors.toList());
        System.out.println(result);

        tasks.stream().map(task -> new String(task.getPoints().toString())).forEach(t -> System.out.println(t));
        List<String> list = tasks.stream().map(task -> new String(task.getPoints().toString())).collect(Collectors.toList());
        System.out.println(list);
    }
}
