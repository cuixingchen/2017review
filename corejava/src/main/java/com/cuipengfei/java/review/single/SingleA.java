package com.cuipengfei.java.review.single;

/**
 * 类装载：加载类，验证类，准备，解析化，初始化
 * <p>
 * 并不是在代码中出现的类，就一定会被加载或者初始化。如果不符合主动使用的条件就不会初始化
 * <p>
 * final常量在类装载的准备阶段初始化
 * Created by cuipengfei on 17-6-6.
 */
public class SingleA {

    static {
        System.out.println("A 初始化");
    }

    private SingleA() {
        System.out.println("A 构造");
    }

    private static class SingleB {
        static {
            System.out.println("B 初始化");
        }

        private static SingleA a = new SingleA();
    }

    /**
     * 执行结果
     * A 初始化
     * B 初始化
     * A 构造
     * <p>
     * 结果分析：
     * 调用A的静态方法所以A会被初始化
     * 调用B的静态属性（非final）会初始化
     * 最后创建A对象就会调用A构造
     *
     * @return
     */
    public static SingleA getInstanceB() {
        return SingleB.a;
    }

    private static class SingleC {
        static {
            System.out.println("C 初始化");
        }

        private static final SingleA a = new SingleA();

    }

    /**
     * 执行结果
     * A 初始化
     * C 初始化
     * A 构造
     * <p>
     * 为什么加了final还会初始化内部类呢？？？不是应该在类装载的准备阶段就给常量赋值了吗
     * 答：因为常量的值不是确定的值，所以类装载的准备阶段不会赋值
     *
     * @return
     */
    public static SingleA getInstanceC() {
        return SingleC.a;
    }

    private static class SingleD {
        static {
            System.out.println("D 初始化");
        }

        private static SingleA a = new SingleA();

        private static final int i = 1;
    }

    /**
     * 执行结果
     * A 初始化
     * <p>
     * 为什么只有A初始化？？
     * 因为i常量在类装载的准备阶段已经赋值了，所以不会初始化了
     *
     * @return
     */
    public static int getInstanceD() {
        return SingleD.i;
    }

    /**
     * 总结一下：对于不确定的static属性，用不用final修饰在类装载这块没有区别，都是在初始化阶段赋值（字节码执行）
     */

}
