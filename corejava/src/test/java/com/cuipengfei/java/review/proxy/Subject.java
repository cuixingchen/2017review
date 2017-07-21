package com.cuipengfei.java.review.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cuipengfei on 17-7-21.
 */
public interface Subject {

    Logger logger = LoggerFactory.getLogger(Subject.class);

    void doSomething();
}
