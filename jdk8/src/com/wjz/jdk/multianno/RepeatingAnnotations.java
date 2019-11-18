package com.wjz.jdk.multianno;

import java.lang.annotation.*;

/**
 * 重复注释
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Repeatable(Filters.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public class Filterable1 {

    }

    @Filters({@Filter("filter3"), @Filter("filter4")})
    public class Filterable2 {

    }

    public static void main(String[] args) {
        for (Filter filter: Filterable1.class.getAnnotationsByType(Filter.class)) {
            System.out.println( filter.value() );
        }
        for (Filter filter: Filterable2.class.getAnnotationsByType(Filter.class)) {
            System.out.println( filter.value() );
        }
        for (Filter filter: Filterable2.class.getAnnotation(Filters.class).value()) {
            System.out.println( filter.value() );
        }
    }

}
