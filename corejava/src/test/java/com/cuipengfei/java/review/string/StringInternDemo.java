package com.cuipengfei.java.review.string;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1.6:intern方法会把首次遇到的字符串实例复制到永久代中
 * 1.7:intern方法实现不会再复制实例，只是在常量池中记录首次出现的实例引用
 * <p>
 * 使用String.intern()方法则可以将一个String类的保存到一个全局String表中，
 * 如果具有相同值的Unicode字符串已经在这个表中，那么该方法返回表中已有字符串的地址，
 * 如果在表中没有相同值的字符串，则将自己的地址注册到表中
 * <p>
 * Created by cuipengfei on 17-7-21.
 */
public class StringInternDemo {

    private static final Logger logger = LoggerFactory.getLogger(StringInternDemo.class);

    @Test
    public void internTest() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        //"计算机软件"这个字符串常量池中没有
        logger.info(str1.intern() == str1 ? "true" : "false");
        //newS这时候就有了
        String newS = "计算机软件";
        logger.info(str1.intern() == newS ? "true" : "false");

        //java这个字符串常量池中事先有
        String str2 = new StringBuilder("ja").append("va").toString();
        logger.info(str2.intern() == str2 ? "true" : "false");
    }

    /**
     * 测试StringBuilder在字符串常量池中创建了对象没
     * <p>
     * 字符串常量池1.7移动到了堆中，并且常量池中可以存放地址
     */
    @Test
    public void stringBuilderTest() {
        String str1 = new StringBuilder("崔鹏飞").toString();
        logger.info(str1.intern() == str1 ? "true" : "false");//false说明"崔鹏飞"这个字符串已经在常量池了

        StringBuilder stringBuilder = new StringBuilder("cuipeng");
        stringBuilder.append("fei");
        String str2 = stringBuilder.toString();
        logger.info(stringBuilder.toString().intern() == str2 ? "true" : "false");
        //false  stringBuilder.toString()创建了一个新String对象  .intern发现常量池中没有匹配的，就把自己放进去了  这样两个对象==比较
        logger.info(str2.intern() == str2 ? "true" : "false");
        //false  str2.intern()发现常量池有匹配的对象（stringBuilder.toString()）上一句代码创建的，就取出来了，这样两个对象==比较
    }
}
