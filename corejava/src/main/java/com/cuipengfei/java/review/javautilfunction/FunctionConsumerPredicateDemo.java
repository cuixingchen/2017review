package com.cuipengfei.java.review.javautilfunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static void main(String[] args) {
        try {
            TestFunction.testDemo();
            TestConsumer.testDemo();
            TestPredicate.testDemo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
