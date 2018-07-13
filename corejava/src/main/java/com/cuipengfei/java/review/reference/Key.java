package com.cuipengfei.java.review.reference;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试Reference类
 * Created by cuipengfei1 on 2018/7/13.
 */
public class Key {

    private String type;

    public Key(String type) {
        this.type = type;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(type+"垃圾回收："+this.toString());
    }

    @Override
    public String toString() {
        return "Key{" +
                "type='" + type + '\'' +
                '}';
    }
}
