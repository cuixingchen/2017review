package com.cuipengfei.java.review.reference;

import java.lang.ref.*;

/**
 * 软引用/弱引用（缓存）、虚引用（垃圾回收）
 * Created by cuipengfei1 on 2018/7/13.
 */
public class ReferenceService {

    public void softService() {
        ReferenceQueue referenceQueue = new ReferenceQueue<Key>();
        Key key = new Key("soft");
        SoftReference softReference = new SoftReference(key, referenceQueue);
        key = null;
        System.gc();
        System.out.println("soft queue:"+referenceQueue.poll());
        System.out.println("soft obj:"+softReference.get());
    }

    public void weakService() {
        ReferenceQueue referenceQueue = new ReferenceQueue<Key>();
        Key key = new Key("weak");
        WeakReference<Key> keyWeakReference = new WeakReference<Key>(key, referenceQueue);
        key = null;
        System.gc();
        Reference reference = referenceQueue.poll();
        System.out.println("weak queue:"+reference.get());
    }

    public void service() {
        Key key = new Key("strong");
        key = null;
        System.gc();
    }

    /**
     * 当GC一但发现了虚引用对象，将会将PhantomReference对象插入ReferenceQueue队列.
     * 而此时PhantomReference所指向的对象并没有被GC回收，而是要等到ReferenceQueue被你真正的处理后才会被回收.
     */
    public void phantomService() throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue<Key>();
        Key key = new Key("phantom");
        PhantomReference<Key> keyPhantomReference = new PhantomReference<Key>(key, referenceQueue);
        System.out.println("phantom before:"+keyPhantomReference.get());//不管在什么情况下会一直返回null
        System.out.println("phantom before queue.poll:"+referenceQueue.poll());
        key = null;
        System.gc();
        // 当GC发现了虚引用，GC会将phanRef插入进我们之前创建时传入的refQueue队列
        // 注意，此时phanRef所引用的obj对象，并没有被GC回收，在我们显式地调用refQueue.poll返回phanRef之后
        // 当GC第二次发现虚引用，而此时JVM将phanRef插入到refQueue会插入失败，此时GC才会对obj进行回收
        System.out.println("phantom queue.poll:"+referenceQueue.poll());

        Thread.sleep(2000);
        System.out.println("phantom 2000 queue.poll:"+referenceQueue.poll());

    }
}
