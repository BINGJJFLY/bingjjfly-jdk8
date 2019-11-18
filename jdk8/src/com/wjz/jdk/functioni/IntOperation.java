package com.wjz.jdk.functioni;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * 函数接口：只有一个抽象方法，可用作 Lambda 表达式的返回类型
 *
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see java.util.function.Supplier
 * @see java.util.function.BiFunction
 *
 */
@FunctionalInterface
public interface IntOperation {

    /**
     * 抽象方法
     *
     * @param left
     * @param right
     * @return
     */
    int compute(int left, int right);

    /**
     * 默认方法
     *
     * @param first
     * @param last
     * @return
     * @see Collection#stream()
     * @see Collection#forEach(Consumer)
     */
    default int add(int first, int last) {
        return first + last;
    }

    /**
     * 静态方法
     *
     * @param i
     * @return
     */
    static String toStr(Integer i) {
        return i.toString();
    }
}
