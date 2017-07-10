package com.cuipengfei.java.review.javautilfunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by cuipengfei on 17-5-20.
 * JDK1.8新特性
 * <p>
 * Function，Consumer，Predicate 接口
 * <p>
 * Function：接受一个参数，返回一个参数。
 * Consumer：接受一个参数，不返回参数。
 * Predicate：用于测试是否符合条件。
 * <p>
 * http://blog.csdn.net/pzxwhc/article/details/48314039
 */
public class FunctionConsumerPredicateDemo {

    /**
     * 一. Function 接口的使用
     * Function 接口有一个参数并且返回一个结果，
     * 并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
     */
    public static class TestFunction {
        public static void testDemo() throws InterruptedException {
            String name = "";
            String name1 = "12345";
            System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空" : inputStr));
            System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长" : inputStr));
        }

        public static String validInput(String name, Function<String, String> function) {
            return function.apply(name);
        }
    }

    /**
     * Consumer 接口的使用
     * Consumer 接口表示执行在单个参数上的操作
     */
    public static class TestConsumer {
        public static void testDemo() throws InterruptedException {
            String name = "";
            String name1 = "12345";

            validInput(name, inputStr ->
                    System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));
            validInput(name1, inputStr ->
                    System.out.println(inputStr.isEmpty() ? "名字不能为空" : "名字正常"));

        }

        public static void validInput(String name, Consumer<String> function) {
            function.accept(name);
        }
    }

    /**
     * Predicate 接口的使用
     * Predicate 接口只有一个参数，返回boolean类型。
     * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）：
     */
    public static class TestPredicate {
        public static void testDemo() throws InterruptedException {
            String name = "";
            String name1 = "12";
            String name2 = "12345";

            System.out.println(validInput(name, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
            System.out.println(validInput(name1, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));
            System.out.println(validInput(name2, inputStr -> !inputStr.isEmpty() && inputStr.length() <= 3));

        }

        public static boolean validInput(String name, Predicate<String> function) {
            return function.test(name);
        }
    }

    /**
     * Supplier 接口的使用
     * Supplier 接口返回一个任意范型的值，
     * 和Function接口不同的是该接口没有任何参数
     */
    public static class TestSupplier {
        public static void testDemo() throws InterruptedException {
            String name = "";
            String name1 = "12345";
            System.out.println(validInput(() -> name.isEmpty() ? "名字不能为空" : name));
            System.out.println(validInput(() -> name1.length() > 3 ? "名字过长" : name1));
        }

        public static String validInput(Supplier<String> function) {
            return function.get();
        }
    }

    public static void main(String[] args) {
        try {
            TestFunction.testDemo();
            TestConsumer.testDemo();
            TestPredicate.testDemo();
            TestSupplier.testDemo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
