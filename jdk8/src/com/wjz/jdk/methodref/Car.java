package com.wjz.jdk.methodref;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用
 */
public class Car {

    /**
     * Reference to a constructor -> ClassName::new
     * 无参构造器
     */
    public Car() {

    }

    public Car(String logo) {

    }

    /**
     * Represents a supplier of results.
     * 结果提供者：Car::new 返回值类型 Supplier<Car>
     *
     * @param supplier
     * @return
     */
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    /**
     * Reference to a static method -> ContainingClass::staticMethodName
     * 静态方法调用，要有一个类型为 Car 的参数，Car::collide 返回值类型 Consumer<Car>
     *
     * @param car
     * @return
     */
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    /**
     * Reference to an instance method of a particular object -> containingObject::instanceMethodName
     * 实例方法调用，不能有任何参数
     */
    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }

    /**
     * Reference to an instance method of an arbitrary object of a particular type -> ContainingType::methodName
     * 引用特定类型的任意对象的实例方法，要有一个类型为 Car 的参数，car::follow 返回值类型 Consumer<Car>
     * @param another
     */
    public void follow(final Car another) {
        System.out.println( "Following the " + another.toString() );
    }

    public void general(String logo) {
        
    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        System.out.println(car);

        final List<Car> cars = Arrays.asList(car);
        Consumer<Car> consumer = Car::collide;
        // 方式1：
        cars.forEach(consumer);
        // 方式2：
        for (Car c : cars) {
            consumer.accept(c);
        }

        cars.forEach(Car::repair);

        Consumer<Car> cm = car::follow;
        // 方式1：
        cars.forEach(cm);
        // 方式2：
        for (Car c : cars) {
            cm.accept(c);
        }
    }
}
