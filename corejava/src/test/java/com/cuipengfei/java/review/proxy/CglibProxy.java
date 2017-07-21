package com.cuipengfei.java.review.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by cuipengfei on 17-7-21.
 */
public class CglibProxy implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CglibProxy.class);

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    public void preIntercept() {
        logger.info("preIntercept-->");
    }

    public void beforeIntercept() {
        logger.info("beforeIntercept-->");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        preIntercept();
        Object result = methodProxy.invokeSuper(o, objects);
        beforeIntercept();
        return result;
    }
}
