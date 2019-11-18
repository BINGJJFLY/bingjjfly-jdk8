package com.wjz.jdk.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class LambdaTest {

    /**
     * 类型声明
     */
    @Test
    public void lambda1() {
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        int rel = intBinaryOperator.applyAsInt(3, 2);
        Assert.assertEquals(5, rel);
    }

    /**
     * 不用类型声明
     */
    @Test
    public void lambda2() {
        IntBinaryOperator intBinaryOperator = (a, b) -> {
            return a + b;
        };
        int rel =intBinaryOperator.applyAsInt(3, 2);
        Assert.assertEquals(5, rel);
    }

    /**
     * 没有大括号及返回语句
     */
    @Test
    public void lambda3() {
        IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
        int rel = intBinaryOperator.applyAsInt(3, 2);
        Assert.assertEquals(5, rel);
    }

    /**
     * 自定义函数式接口
     */
    @Test
    public void lambda4() {
        IntOperation intOperation = (a, b) -> a + b;
        int rel = intOperation.compute(3, 2);
        Assert.assertEquals(5, rel);
    }

    /**
     * 带类型带括号
     */
    @Test
    public void lambda5() {
        final Consumer<String> stringConsumer = (String message) -> {
            Assert.assertEquals("hello world!", message);
        };
        stringConsumer.accept("hello world!");
    }

    /**
     * 带括号
     */
    @Test
    public void lambda6() {
        final Consumer<String> stringConsumer = (message) -> {
            Assert.assertEquals("hello world!", message);
        };
        stringConsumer.accept("hello world!");
    }

    /**
     * 不带括号
     */
    @Test
    public void lambda7() {
        final Consumer<String> stringConsumer = message -> {
            Assert.assertEquals("hello world!", message);
        };
        stringConsumer.accept("hello world!");
    }

    /**
     * 不带大括号
     */
    @Test
    public void lambda8() {
        final Consumer<String> stringConsumer = message ->
                Assert.assertEquals("hello world!", message);
        stringConsumer.accept("hello world!");
    }

    /**
     * Lambda表达式代替内部类
     */
    @Test
    public void lambda9() {
        new LambdaTest().innerInterface((left, right) -> left + right);
    }

    public int innerInterface(IntOperation operation) {
        return operation.compute(3, 2);
    }

    /**
     * lambda 表达式只能引用标记了 final 的外层局部变量，或隐性具有 final 语义的外层局部变量
     * Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
     *
     * lambda表达式必须存储自由变量，含有自由变量的代码块才被称之为“闭包（closure）”
     * lambda表达式就是闭包，事实上内部类一直都是闭包
     * 参考：https://my.oschina.net/fhd/blog/419892
     */
    @Test
    public void lambda10() {
        // 变量被lambda表达式引用的话则不能被修改
        final String val = "final variable";
        List<String> list = new ArrayList<>();
        // Variable 'message' is already defined in the scope
        // String message = null;
        Consumer consumer = message -> {
            // Variable used in lambda expression should be final or effectively final
            // val = "hello";
            list.add("hello world");
            System.out.println(message + val);
        };
        consumer.accept("must use ");
    }

    /**
     * 函数式接口：只能有一个抽象类
     * 可以加 @FunctionalInterface 注解修饰
     */
    interface IntOperation {
        int compute(int left, int right);
    }
}
