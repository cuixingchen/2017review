package com.cuipengfei.java.review.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by cuipengfei on 17-7-21.
 */
public class JavaProxyTest {

    @Test
    public void test() {
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new ProxyHandler((realSubject)));
        proxySubject.doSomething();
    }
}
