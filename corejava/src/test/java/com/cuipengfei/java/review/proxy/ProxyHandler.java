package com.cuipengfei.java.review.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by cuipengfei on 17-7-21.
 */
public class ProxyHandler implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);

    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public void beforeInvoke() {
        logger.info("beforeInvoke-->");
    }

    public void preInvoke() {
        logger.info("preInvoke-->");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preInvoke();
        Object obj = method.invoke(proxied, args);
        beforeInvoke();
        return obj;

    }
}
