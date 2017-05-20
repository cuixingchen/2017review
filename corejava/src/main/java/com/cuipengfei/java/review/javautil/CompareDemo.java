package com.cuipengfei.java.review.javautil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cuipengfei on 17-5-20.
 * <p>
 * 实现Comparable接口和Comparator接口区别
 * <p>
 * 静态内部类的简单使用
 */
public class CompareDemo {
    /**
     * 实现Comparable接口，实现compareTo方法进行比较
     */
    private static class Student implements Comparable<Student> {
        private String name;
        private Integer age;
        private Integer index;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", index=" + index +
                    '}';
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public int compareTo(Student o) {
            return index - o.index;
        }
    }

    public static void main(String[] args) {
        /**
         * 创建stu1实现
         */
        Student stu1 = new Student();
        stu1.setName("stu1");
        stu1.setAge(1);
        stu1.setIndex(2);
        System.out.println(stu1);
        /**
         * 创建stu2实体
         */
        Student stu2 = new Student();
        stu2.setName("stu2");
        stu2.setAge(2);
        stu2.setIndex(1);
        /**
         * 打印两次观察两个实现内容是否一样，不一样说明静态内部类的非静态属性和和非静态方法依赖于具体的实现
         */
        System.out.println(stu1);
        System.out.println(stu2);
        /**
         * 静态内部类内部使用跟普通一样，只不过静态内部类不依赖外部类的实现，可以直接外部类.静态内部类使用
         */
        List<Student> studentList = new ArrayList();
        studentList.add(stu2);
        studentList.add(stu1);
        System.out.println(studentList);
        Collections.sort(studentList);
        System.out.println(studentList);
        /**
         * 创建一个规则比较器Comparator，这样可以灵活比较并且不改动待比较的实体
         */
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(studentList);
    }
}
