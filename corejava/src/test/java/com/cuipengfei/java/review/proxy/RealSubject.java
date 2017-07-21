package com.cuipengfei.java.review.proxy;

/**
 * Created by cuipengfei on 17-7-21.
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        logger.info("RealSubject-->doSomething");
    }
}
