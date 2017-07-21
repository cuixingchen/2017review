package com.cuipengfei.java.review.reflect;

import com.cuipengfei.java.review.javautil.CompareTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制是在运行状态中，
 * 对于任意一个类，都能够知道这个类的所有属性和方法；
 * 对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 * <p>
 * 反射机制主要提供了以下功能：
 * 在运行时判断任意一个对象所属的类；
 * 在运行时构造任意一个类的对象；
 * 在运行时判断任意一个类所具有的成员变量和方法；
 * 在运行时调用任意一个对象的方法；
 * 生成动态代理。
 * <p>
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * Created by cuipengfei on 17-7-21.
 */
public class TestReflect {

    private static final Logger logger = LoggerFactory.getLogger(TestReflect.class);

    @Test
    public void getNameTest() {
        ReflectBean reflectBean = new ReflectBean();
        logger.info(reflectBean.getClass().getName());
    }

    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("com.cuipengfei.java.review.reflect.ReflectBean");
        logger.info(class1.getName());
    }

    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.cuipengfei.java.review.reflect.ReflectBean");
        ReflectBean reflectBean = (ReflectBean) class1.newInstance();
        reflectBean.setCode("123456");
        reflectBean.setName("反射类名称");
        logger.info(reflectBean.toString());

        Constructor<?>[] cons = class1.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            logger.info(cons[i].getName());
            Class<?>[] clazzs = cons[i].getParameterTypes();
            for (int j = 0; j < clazzs.length; j++) {
                logger.info(clazzs[j].getName());
            }
        }
        reflectBean = (ReflectBean) cons[1].newInstance("name", "code");
        logger.info(reflectBean.toString());
    }

    @Test
    public void methodTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = Class.forName("com.cuipengfei.java.review.reflect.ReflectBean");
        Method method = class1.getMethod("toString");
        logger.info(method.invoke(class1.newInstance()).toString());
    }

    @Test
    public void fieldTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> class1 = Class.forName("com.cuipengfei.java.review.reflect.ReflectBean");
        Object obj = class1.newInstance();
        Field field = class1.getDeclaredField("name");
        field.set(obj, "反射setName");
        logger.info(obj.toString());
    }
}
