package com.cuipengfei.java.review.lock;

/**
 * 类锁和对象锁区别
 * Created by cuipengfei on 17-6-7.
 */
public class ClassInstanceLock {

    /**
     * 类锁
     */
    private static class LockA {
        public static void printStatic() {
            synchronized (LockA.class) {
                System.out.println("LockA类进入类锁printStatic同步区");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("LockA类走出类锁printStatic同步区");
            }
        }

        public void print() {
            synchronized (this) {
                System.out.println("LockA类进入类锁print同步区");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("LockA类走出类锁print同步区");
            }
        }
    }

    /**
     * 对象锁
     */
    private static class LockB {

        private String message;

        public LockB(String message) {
            this.message = message;
        }

        public void print() {
            synchronized (this) {
                System.out.println("LockB类进入类锁printStatic同步区,message:" + message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("LockB类走出类锁printStatic同步区,message:" + message);
            }
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 执行结果：
     * LockA类进入类锁printStatic同步区
     * LockA类进入类锁print同步区
     * LockA类走出类锁print同步区
     * LockA类走出类锁printStatic同步区
     * LockB类进入类锁printStatic同步区,message:二次赋值
     * LockB类走出类锁printStatic同步区,message:二次赋值
     * <p>
     * 分析：说明类锁跟对象锁没有依赖关系
     * <p>
     * 下面有个二次赋值是不是存在闭包问题具体分析去看函数式编程例子：javautilfunction包下面demo
     */
    public static void main(String[] args) {
        new Thread(() -> LockA.printStatic()).start();
        LockA lockA = new LockA();
        new Thread(() -> lockA.print()).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockB lockB = new LockB("第一次实例化");
        new Thread(() -> lockB.print()).start();
        lockB.setMessage("二次赋值");

    }

}
