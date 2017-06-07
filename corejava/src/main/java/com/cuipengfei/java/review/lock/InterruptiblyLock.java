package com.cuipengfei.java.review.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可中断锁
 * synchronized 不可中断锁
 * ReentrantLock 可中断锁
 * <p>
 * 在Java的线程Thread类中有三个方法，比较容易混淆，在这里解释一下
 * （1）interrupt：置线程的中断状态
 * （2）isInterrupt：线程是否中断
 * （3）interrupted：返回线程的上次的中断状态，并清除中断状态
 * Created by cuipengfei on 17-6-7.
 */
public class InterruptiblyLock {

    private ReentrantLock lock = new ReentrantLock();

    public void print(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "方法print同步区域获得锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        } finally {
            lock.unlock();
            System.out.println(thread.getName() + "方法print同步区域释放锁");
        }
    }

    /**
     * 执行结果：
     * main当前线程名称：main
     * thread0当前线程名称：Thread-0
     * Thread-0方法print同步区域获得锁
     * thread1当前线程名称：Thread-1
     * Thread-1被中断
     * <p>
     * 分析结果：Thread-1在等待锁的过程lock.lockInterruptibly()中被中断了
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main当前线程名称：" + Thread.currentThread().getName());
        InterruptiblyLock interruptiblyLock = new InterruptiblyLock();
        Thread thread0 = new Thread(() -> {
            try {
                System.out.println("thread0当前线程名称：" + Thread.currentThread().getName());
                interruptiblyLock.print(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("thread1当前线程名称：" + Thread.currentThread().getName());
                interruptiblyLock.print(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });
        thread0.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1中断状态：" + thread1.isInterrupted());
        thread1.interrupt();
        System.out.println("thread1中断状态：" + thread1.isInterrupted());

        /**
         * 获取锁后的线程中断不了，如下面的打印状态
         * thread0中断状态：true
         * 虽然是中断状态，但是线程还是正常运行
         * 中断：设置线程中断状态，阻塞方法（类似sleep,join（等待该线程终止）,wait）抛出异常
         */
        thread0.interrupt();
        System.out.println("thread0中断状态：" + thread0.isInterrupted());
    }
}
