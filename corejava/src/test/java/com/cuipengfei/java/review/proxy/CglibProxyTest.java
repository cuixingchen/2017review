package com.cuipengfei.java.review.proxy;

import org.junit.Test;

/**
 * Created by cuipengfei on 17-7-21.
 */
public class CglibProxyTest {

    @Test
    public void test() {
        CglibProxy cglibProxy = new CglibProxy();
        RealSubject realSubject = (RealSubject) cglibProxy.getProxy(RealSubject.class);
        realSubject.doSomething();
    }
}
