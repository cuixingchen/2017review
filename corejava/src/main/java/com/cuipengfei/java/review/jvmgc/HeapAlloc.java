package com.cuipengfei.java.review.jvmgc;

/**
 * Created by cuipengfei on 17-6-1.
 */
public class HeapAlloc {
    public static void main(String[] args){
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+"bytes");
        System.out.print("free men=");
        System.out.println(Runtime.getRuntime().freeMemory()+"bytes");
        System.out.print("total men=");
        System.out.println(Runtime.getRuntime().totalMemory()+"bytes");
        byte[] b=new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+"bytes");
        System.out.print("free men=");
        System.out.println(Runtime.getRuntime().freeMemory()+"bytes");
        System.out.print("total men=");
        System.out.println(Runtime.getRuntime().totalMemory()+"bytes");
        b=new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+"bytes");
        System.out.print("free men=");
        System.out.println(Runtime.getRuntime().freeMemory()+"bytes");
        System.out.print("total men=");
        System.out.println(Runtime.getRuntime().totalMemory()+"bytes");
    }
}
