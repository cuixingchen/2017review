package com.cuipengfei.java.review.javautil;

/**
 * Created by cuipengfei on 17-5-20.
 * <p>
 * Java对象的eqauls方法和hashCode方法是这样规定的：
 * 1、相等（相同）的对象必须具有相等的哈希码（或者散列码）。
 * 2、如果两个对象的hashCode相同，它们并不一定相同。
 */
public class ObjectMethodDemo {

    /**
     * 默认是对两个对象的地址值进行的比较，String 、Math、Integer、Double等这些封装类在使用equals()方法时，已经覆盖了object类的equals()方法
     * 它的性质有：
     * 自反性（reflexive）。对于任意不为null的引用值x，x.equals(x)一定是true。
     * 对称性（symmetric）。对于任意不为null的引用值x和y，当且仅当x.equals(y)是true时，y.equals(x)也是true。
     * 传递性（transitive）。对于任意不为null的引用值x、y和z，如果x.equals(y)是true，同时y.equals(z)是true，那么x.equals(z)一定是true。
     * 一致性（consistent）。对于任意不为null的引用值x和y，如果用于equals比较的对象信息没有被修改的话，多次调用时x.equals(y)要么一致地返回true要么一致地返回false。
     * 对于任意不为null的引用值x，x.equals(null)返回false。
     * <p>
     * 需要注意的是当equals()方法被override时，hashCode()也要被override。按照一般hashCode()方法的实现来说，相等的对象，它们的hash code一定相等
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    /**
     * 它的性质是：
     * 在一个Java应用的执行期间，如果一个对象提供给equals做比较的信息没有被修改的话，该对象多次调用hashCode()方法，该方法必须始终如一返回同一个integer。
     * 如果两个对象根据equals(Object)方法是相等的，那么调用二者各自的hashCode()方法必须产生同一个integer结果。
     * 并不要求根据equals(java.lang.Object)方法不相等的两个对象，调用二者各自的hashCode()方法必须产生不同的integer结果。
     * 然而，程序员应该意识到对于不同的对象产生不同的integer结果，有可能会提高hash table的性能
     *
     * @return
     */
    @Override
    public int hashCode() {
        return 0;
    }

}
