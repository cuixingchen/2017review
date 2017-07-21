package com.cuipengfei.java.review.reflect;

/**
 * 发射demo测试辅助bean类
 * Created by cuipengfei on 17-7-21.
 */
public class ReflectBean {

    private String name;

    private String code;

    public ReflectBean() {
    }

    public ReflectBean(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "ReflectBean{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
